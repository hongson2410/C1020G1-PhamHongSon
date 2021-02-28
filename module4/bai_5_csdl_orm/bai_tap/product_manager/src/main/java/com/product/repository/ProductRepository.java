package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(Long id);

    void remove(Long id);
}
