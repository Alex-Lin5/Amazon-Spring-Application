package com.revature.AmazonSpringApp.repository;

import com.revature.AmazonSpringApp.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartDao extends JpaRepository<Cart, Integer> {
    @Query("SELECT * FROM Cart WHERE user_id = ?1")
    Optional<Cart> findByUserId(int userId);
    boolean addProduct(int cartId, int productId);
}
