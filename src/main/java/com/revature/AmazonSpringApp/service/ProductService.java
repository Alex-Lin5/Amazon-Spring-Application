package com.revature.AmazonSpringApp.service;

import com.revature.AmazonSpringApp.entity.Product;
import com.revature.AmazonSpringApp.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements ProductServiceInterface{
    @Autowired
    ProductDao productDao;

    @Override
    public Product createProduct(Product p) {
        if(productDao.findByNameAndDescription(p.getName(), p.getDescription()).isEmpty())
            return productDao.save(p);
        return null;
    }

    @Override
    public Product getProduct(Product p) {
        Optional<Product> productFind = productDao.findById(p.getId());
        return productFind.orElse(null);
    }

    @Override
    public Product editProduct(Product p) {
        Optional<Product> productFind = productDao.findById(p.getId());
        if(productFind.isPresent())
            return productDao.save(p);
        return null;
    }

    @Override
    public Product removeProduct(Product p) {
        Optional<Product> productFind = productDao.findById(p.getId());
        if(productFind.isPresent()){
            productDao.delete(p);
            return p;
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }
}
