package com.revature.AmazonSpringApp.service;

import com.revature.AmazonSpringApp.entity.Cart;
import com.revature.AmazonSpringApp.entity.Product;
import com.revature.AmazonSpringApp.entity.User;
import com.revature.AmazonSpringApp.repository.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService implements CartServiceInterface{
    @Autowired
    private CartDao cartDao;

    @Override
    public User fromUser() {
        return null;
    }

    @Override
    public List<Product> getProductsInCart(Cart cart) {
        return List.of();
    }

    @Override
    public void addToCart(Cart cart, Product product) {

    }

    @Override
    public void removeFromCart(Cart cart, Product product) {

    }

    @Override
    public void checkout() {

    }

    @Override
    public void payment() {

    }
}
