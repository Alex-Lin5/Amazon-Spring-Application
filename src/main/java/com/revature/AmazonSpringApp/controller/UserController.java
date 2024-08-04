package com.revature.AmazonSpringApp.controller;

import com.revature.AmazonSpringApp.entity.Cart;
import com.revature.AmazonSpringApp.entity.Product;
import com.revature.AmazonSpringApp.entity.Profile;
import com.revature.AmazonSpringApp.entity.User;
import com.revature.AmazonSpringApp.exceptions.AuthenticationException;
import com.revature.AmazonSpringApp.exceptions.ProfileException;
import com.revature.AmazonSpringApp.service.ProductServiceInterface;
import com.revature.AmazonSpringApp.service.ProfileServiceInterface;
import com.revature.AmazonSpringApp.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController implements UserControllerInterface{
//    @Autowired
//    private ProductServiceInterface productService;
    @Autowired
    private UserServiceInterface userService;
    @Autowired
    private ProfileServiceInterface profileService;

    @Override
    public Cart getCart() {
        return null;
    }

    @Override
    public void addToCart(Product p) {

    }

    @Override
    public void removeFromCart(Product p) {

    }

    @Override
    public void checkout() {

    }

    @Override
    public void payment() {

    }

    @Override
    public Profile createProfile(Profile profile) {
        Profile profileReturned = profileService.createProfile(profile);
        if(profileReturned == null){
            throw new ProfileException("Profile creation failed.");
        }
        return profileReturned;
    }

    @Override
    public Profile getProfile() {
        return null;
    }

    @Override
    public Profile editProfile(Profile profile) {
        return null;
    }

    @Override
    public void removeProfile() {

    }

    @Override
    @PostMapping(value = "register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User userReturned = userService.register(user);
        if(userReturned == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(userReturned);
    }


    @Override
    @PostMapping(value = "login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if(userService.login(user) == null){
            throw new AuthenticationException("Login Failed.");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login Failed.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Login Success.");
    }

    @Override
    public ResponseEntity<String> logout() {
        return ResponseEntity.status(HttpStatus.OK).body("User logged out.");

    }
}
