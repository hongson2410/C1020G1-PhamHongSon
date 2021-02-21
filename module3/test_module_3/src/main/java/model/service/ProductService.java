package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProduct();

    String save (String product_name, String price, String discount, String stock);
}
