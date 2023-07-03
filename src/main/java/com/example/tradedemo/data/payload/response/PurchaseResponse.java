package com.example.tradedemo.data.payload.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PurchaseResponse {

    private UUID id;
}
