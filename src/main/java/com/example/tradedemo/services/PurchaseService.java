package com.example.tradedemo.services;

import com.example.tradedemo.data.dbmodel.Product;
import com.example.tradedemo.data.dbmodel.Purchase;
import com.example.tradedemo.data.dbmodel.Users;
import com.example.tradedemo.data.enums.UserType;
import com.example.tradedemo.data.payload.request.PurchaseRequest;
import com.example.tradedemo.data.payload.response.PurchaseResponse;
import com.example.tradedemo.mapper.PurchaseMapper;
import com.example.tradedemo.repositories.ProductRepository;
import com.example.tradedemo.repositories.PurchaseRepository;
import com.example.tradedemo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseMapper purchaseMapper;
    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public PurchaseResponse createPurchase(PurchaseRequest purchaseRequest, UUID userId, UUID productId) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        Product product = productRepository.findByProductId(productId).orElseThrow(() -> new RuntimeException("Product Not Found"));
        BigDecimal discount = checkUserType(user.getUserType());
        Boolean time = isTwoYearsPassed(user.getCreatedDate());
        BigDecimal finalPurchasePrice = finalPrice(discount, time, product.getProductPrice());

        saveAllData(finalPurchasePrice, product, user);

        return purchaseMapper.toResponseFromPurchase(purchaseRepository.findByUserId(userId));
    }


    private BigDecimal checkUserType(UserType userType) {
        return switch (userType) {
            case GOLD -> new BigDecimal("0.7");
            case SILVER -> new BigDecimal("0.8");
            case NORMAL -> new BigDecimal("0.9");
        };
    }

    private boolean isTwoYearsPassed(ZonedDateTime date) {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime twoYearsAgo = now.minus(2, ChronoUnit.YEARS);

        return date.isBefore(twoYearsAgo);
    }

    private BigDecimal finalPrice(BigDecimal discount, Boolean time, BigDecimal price) {
        BigDecimal finalPurchasePrice = price.multiply(discount);

        if (time) {
            finalPurchasePrice.multiply(BigDecimal.valueOf(0.95));
        }

        int intPrice = finalPurchasePrice.intValue();
        if ((intPrice / 200) != 0) {
            int cashDiscount = (intPrice / 200) * 5;
            finalPurchasePrice = finalPurchasePrice.subtract(BigDecimal.valueOf(cashDiscount));
        }

        return finalPurchasePrice;
    }

    private void saveAllData(BigDecimal finalPurchasePrice, Product product, Users user) {
        purchaseRepository.save(Purchase.builder()
                .purchaseId(UUID.randomUUID())
                .createdDate(ZonedDateTime.now())
                .purchasePrice(finalPurchasePrice)
                .products(List.of(product))
                .user(user)
                .build());

        productRepository.save(product);

        userRepository.save(user);
    }
}
