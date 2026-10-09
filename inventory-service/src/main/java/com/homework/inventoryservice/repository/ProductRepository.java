package com.homework.inventoryservice.repository;

import com.homework.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
