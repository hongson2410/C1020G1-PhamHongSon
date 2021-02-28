package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Long id);

    void remove(Long id);
}
