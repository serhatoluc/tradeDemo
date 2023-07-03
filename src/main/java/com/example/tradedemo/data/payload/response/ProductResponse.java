package com.example.tradedemo.data.payload.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductResponse {

    private String name;
    private BigDecimal price;
    private UUID id;

}
