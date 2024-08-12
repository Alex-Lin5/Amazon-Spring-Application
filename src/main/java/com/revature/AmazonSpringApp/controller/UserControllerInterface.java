package com.revature.AmazonSpringApp.controller;

import com.revature.AmazonSpringApp.entity.Cart;
import com.revature.AmazonSpringApp.entity.Product;
import com.revature.AmazonSpringApp.entity.Profile;
import com.revature.AmazonSpringApp.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface UserControllerInterface {
    ResponseEntity<Cart> getCart(int userId);
    ResponseEntity<String> addProduct(int cartId, Product p);
    void removeFromCart(Product p);
    void checkout();
    void payment();

    Profile createProfile(Profile profile);
    Profile getProfile();
    Profile editProfile(Profile profile);
    void removeProfile();

    ResponseEntity<User> register(User user);
    ResponseEntity<String> login(User user);
    ResponseEntity<String> logout();



}
