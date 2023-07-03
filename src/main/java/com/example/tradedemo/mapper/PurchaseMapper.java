package com.example.tradedemo.mapper;

import com.example.tradedemo.data.dbmodel.Purchase;
import com.example.tradedemo.data.payload.response.PurchaseResponse;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {

    public PurchaseResponse toResponseFromPurchase(Purchase purchase) {
        return PurchaseResponse.builder()
                .id(purchase.getPurchaseId())
                .build();
    }

}
