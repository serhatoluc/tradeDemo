package com.example.tradedemo.controller;

import com.example.tradedemo.data.payload.request.PurchaseRequest;
import com.example.tradedemo.data.payload.response.PurchaseResponse;
import com.example.tradedemo.services.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/create-purchase")
    public ResponseEntity<PurchaseResponse> createPurchase(@RequestBody PurchaseRequest purchaseRequest,
                                                           @RequestParam(value = "userId") UUID userId,
                                                           @RequestParam(value = "productId") UUID productId) {
        return ResponseEntity.ok(purchaseService.createPurchase(purchaseRequest, userId, productId));
    }

    //TODO: Diğer endpoint'ler eklenebilir fakat task özelinde tekrar olacağı için eklemiyorum.
}
