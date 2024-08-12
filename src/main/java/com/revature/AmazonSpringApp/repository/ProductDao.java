package com.revature.AmazonSpringApp.repository;

import com.revature.AmazonSpringApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Optional<Product> findByNameAndDescription(String name, String description);
    @Query("UPDATE Product SET cartId = 1? WHERE id=2?")
    boolean addToCart(int cartId, int productId);
    List<Product> findAllByCartId(int cartId);
}
