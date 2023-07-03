package com.example.tradedemo.mapper;

import com.example.tradedemo.data.dbmodel.Product;
import com.example.tradedemo.data.payload.request.ProductRequest;
import com.example.tradedemo.data.payload.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductMapper {

    public Product toProductFromProductRequest(ProductRequest productRequest) {
        return Product.builder()
                .productId(UUID.randomUUID())
                .productName(productRequest.getName())
                .productPrice(productRequest.getPrice())
                .build();
    }

    public ProductResponse toProductResponseFromProductRequest(ProductRequest productRequest) {
        return ProductResponse.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .build();
    }

    public List<ProductResponse> toProductResponsesFromProducts(List<Product> products) {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            productResponses.add(ProductResponse.builder()
                    .id(product.getProductId())
                    .price(product.getProductPrice())
                    .name(product.getProductName())
                    .build());
        }
        return productResponses;
    }
}
