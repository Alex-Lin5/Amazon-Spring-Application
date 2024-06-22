package com.revature.AmazonSpringApp.repository;

import com.revature.AmazonSpringApp.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartDao extends JpaRepository<Cart, Integer> {
//    @Query
//    Cart findCart(int id);
}
