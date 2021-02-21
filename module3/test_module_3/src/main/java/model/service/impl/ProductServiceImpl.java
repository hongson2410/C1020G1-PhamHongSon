package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.repository.impl.ProductRepositoryImpl;
import model.service.ProductService;
import model.validate.Input;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepositoryImpl();
    Input input = new Input();

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAllProduct();
    }

    @Override
    public String save(String product_name, String price, String discount, String stock) {
        Product product;

        if (!input.inputString(product_name)) {
            return "Name must have value";
        }

        if (!input.inputInt(price)) {
            return "Price must have value";
        } else  if (Integer.parseInt(price) < 100) {
            return "Price > 100";
        }

        if (!input.inputInt(stock)) {
            return "Stock must have value";
        } else  if (Integer.parseInt(stock) < 10) {
            return "Stock > 10";
        }

        product = new Product(product_name, Integer.parseInt(price), Integer.parseInt(discount),
                Integer.parseInt(stock));
        productRepository.save(product);
        return "Product was update";
    }
}
