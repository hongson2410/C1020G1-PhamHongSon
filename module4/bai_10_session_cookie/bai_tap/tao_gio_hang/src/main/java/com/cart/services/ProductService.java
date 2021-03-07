package com.cart.services;

import com.cart.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAllProduct(Pageable pageable);

    Product findById(int id);

    void save(Product product);

    void deleteOne(Product product);

    void deleteAll();
}
