package com.revature.AmazonSpringApp.service;

import com.revature.AmazonSpringApp.entity.Cart;
import com.revature.AmazonSpringApp.entity.Product;
import com.revature.AmazonSpringApp.entity.User;
import com.revature.AmazonSpringApp.repository.CartDao;
import com.revature.AmazonSpringApp.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartService implements CartServiceInterface{
    @Autowired
    private CartDao cartDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public User fromUser() {
        return null;
    }

    @Override
    public List<Product> getProductsInCart(Cart cart) {
        return productDao.findAllByCartId(cart.getId());
    }

    @Override
    public String addProduct(Cart cart, Product product) {
        Optional<Product> productFound = productDao.findByNameAndDescription(product.getName(), product.getDescription());
        Product productAdd;
        if(productFound.isEmpty()){
            return String.format("Product %s add to Cart %d failed, product is not existed.\n", product.getName(), cart.getId());
        }
        productAdd = productFound.get();
        if(productDao.addToCart(cart.getId(), productAdd.getId()))
            return String.format("Product %s add to Cart %d success.\n", product.getName(), cart.getId());
        return String.format("Product %s add to Cart %d failed, product cannot add to cart.\n", product.getName(), cart.getId());
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
