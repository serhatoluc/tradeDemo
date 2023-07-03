package com.example.tradedemo.repositories;

import com.example.tradedemo.data.dbmodel.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
    Purchase findByUserId(UUID userId);
}
