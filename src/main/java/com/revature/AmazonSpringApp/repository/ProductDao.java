package com.revature.AmazonSpringApp.repository;

import com.revature.AmazonSpringApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Optional<Product> findByNameAndDescription(String name, String description);
}
