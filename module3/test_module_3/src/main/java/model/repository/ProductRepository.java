package model.repository;

import model.bean.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAllProduct();

    void save(Product product);
}
