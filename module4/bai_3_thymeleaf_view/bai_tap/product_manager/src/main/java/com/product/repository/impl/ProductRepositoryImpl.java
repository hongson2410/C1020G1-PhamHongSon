package com.product.repository.impl;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Iphone-6", "Apple", "smart-phone", 200));
        productMap.put(2, new Product(2, "Galaxy-note-7", "Samsung", "Tivi", 300));
        productMap.put(3, new Product(3, "Sony Smart TV KDL-40W650D", "Sony", "Tivi", 700));
        productMap.put(4, new Product(4, "LG Smart TV 43UN7290PTF", "LG", "Tivi", 200));
        productMap.put(5, new Product(5, "Iphone-X", "Apple", "smart-phone", 500));
        productMap.put(6, new Product(6, "Oppo A15s", "Oppo", "smart-phone", 150));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
