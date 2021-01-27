package repository.impl;

import bean.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap = new TreeMap<>();

    static {
        productMap.put(1, new Product(1,"phone",500,"iphone-6","aplle"));
        productMap.put(2, new Product(2,"tivi",2000,"4k","samsung"));
        productMap.put(3, new Product(3,"fan",20,"water-steam","sanyo"));
        productMap.put(4, new Product(4,"phone",300,"galaxy-note7","samsung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
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

    @Override
    public List<Product> findByName(String name) {
        List<Product> tempProduct = new ArrayList<>();
        List<Product> productList = new ArrayList<>(productMap.values());
        for (Product product: productList){
            if (product.getName().contains(name)){
                tempProduct.add(product);
            }
        }
        return tempProduct;
    }
}
