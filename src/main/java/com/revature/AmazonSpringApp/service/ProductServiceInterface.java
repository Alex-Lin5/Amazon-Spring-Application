package com.revature.AmazonSpringApp.service;

import com.revature.AmazonSpringApp.entity.Product;

import java.util.List;

public interface ProductServiceInterface {
    Product createProduct(Product p);
    Product getProduct(Product p);
    Product editProduct(Product p);
    Product removeProduct(Product p);
    List<Product> getAllProducts();

}
