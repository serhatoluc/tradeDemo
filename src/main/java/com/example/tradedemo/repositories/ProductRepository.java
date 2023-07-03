package com.example.tradedemo.repositories;

import com.example.tradedemo.data.dbmodel.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByProductId(UUID productId);
}
