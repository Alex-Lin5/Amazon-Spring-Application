package com.revature.AmazonSpringApp.service;

import com.revature.AmazonSpringApp.entity.Cart;
import com.revature.AmazonSpringApp.entity.Profile;
import com.revature.AmazonSpringApp.entity.User;

public interface UserServiceInterface {
    User register(User user);
    User login(User user);
    String verify(User user, String otp);
    void logout();
    void block(User user);
    void unblock(User user);

    Cart getCart(User user);
}
