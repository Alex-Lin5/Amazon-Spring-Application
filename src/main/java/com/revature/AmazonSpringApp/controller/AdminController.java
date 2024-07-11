package com.revature.AmazonSpringApp.controller;

import com.revature.AmazonSpringApp.entity.Product;
import com.revature.AmazonSpringApp.entity.User;
import com.revature.AmazonSpringApp.service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "admin")
public class AdminController implements AdminControllerInterface {
    @Autowired
    ProductServiceInterface productService;

    @Override
    @GetMapping(value = "getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @Override
    @GetMapping(value = "getOne")
    public ResponseEntity<Product> getProduct(@RequestBody Product product) {
        Product productFind = productService.getProduct(product);
        if(productFind == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(productFind);
    }

    @Override
    @PostMapping(value = "create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product productCreated = productService.createProduct(product);
        if(productCreated == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(productCreated);
    }

    @Override
    @PatchMapping(value = "edit")
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        Product productEdit = productService.editProduct(product);
        if(productEdit == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(productEdit);
    }

    @Override
    @DeleteMapping(value = "delete")
    public ResponseEntity<String> removeProduct(@RequestBody Product product) {
        Product productDelete = productService.removeProduct(product);
        if(productDelete == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.status(HttpStatus.OK).body("product deleted");
    }

    @Override
    public ResponseEntity<String> blockUser(User user) {
        return null;
    }

    @Override
    public ResponseEntity<String> unblockUser(User user) {
        return null;
    }

    @Override
    public ResponseEntity<String> login(User user) {
        return null;
    }

    @Override
    public ResponseEntity<String> logout() {
        return null;
    }
}
