package com.revature.AmazonSpringApp.controller;

import com.revature.AmazonSpringApp.entity.Product;
import com.revature.AmazonSpringApp.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminControllerInterface {
    ResponseEntity<List<Product>> getAllProducts();
    ResponseEntity<Product> getProduct(Product product);
    ResponseEntity<Product> createProduct(Product product);
    ResponseEntity<Product> editProduct(Product product);
    ResponseEntity<String> removeProduct(Product product);

    ResponseEntity<String> blockUser(User user);
    ResponseEntity<String> unblockUser(User user);
    ResponseEntity<String> login(User user);
    ResponseEntity<String> logout();

}
