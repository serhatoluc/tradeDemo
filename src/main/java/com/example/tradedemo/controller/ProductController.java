package com.example.tradedemo.controller;

import com.example.tradedemo.data.payload.request.ProductRequest;
import com.example.tradedemo.data.payload.response.ProductResponse;
import com.example.tradedemo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create-product")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    //TODO: Diğer endpoint'ler eklenebilir fakat task özelinde tekrar olacağı için eklemiyorum.
}
