package com.revature.AmazonSpringApp.service;

import com.revature.AmazonSpringApp.entity.Cart;
import com.revature.AmazonSpringApp.entity.Product;
import com.revature.AmazonSpringApp.entity.User;

import java.util.List;

public interface CartServiceInterface {
    User fromUser();
    List<Product> getProductsInCart(Cart cart);
    void adcToCart(Cart cart, Product product);
    void removeFromCart(Cart cart, Product product);
    void checkout();
    void payment();
}
