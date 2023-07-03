package com.example.tradedemo.data.payload.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductRequest {

    private String name;
    private BigDecimal price;
    
}
