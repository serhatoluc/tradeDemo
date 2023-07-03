package com.example.tradedemo.services;

import com.example.tradedemo.data.payload.request.ProductRequest;
import com.example.tradedemo.data.payload.response.ProductResponse;
import com.example.tradedemo.mapper.ProductMapper;
import com.example.tradedemo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        productRepository.save(productMapper.toProductFromProductRequest(productRequest));
        return productMapper.toProductResponseFromProductRequest(productRequest);
    }

    public List<ProductResponse> getAllProducts() {
        return productMapper.toProductResponsesFromProducts(productRepository.findAll());
    }
}
