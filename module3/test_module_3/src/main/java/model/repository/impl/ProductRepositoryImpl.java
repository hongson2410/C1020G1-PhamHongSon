package model.repository.impl;

import model.bean.Product;
import model.repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SQL_FIND_ALL_PRODUCT = "select * " +
            "from product";

    private static final String SQL_INSERT_PRODUCT = "insert into product (product_name,price,discount,stock) " +
            "value (?,?,?,?)";

    @Override
    public List<Product> findAllProduct() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()) {
                product = new Product();
                product.setProduct_id(Integer.parseInt(resultSet.getString("product_id")));
                product.setProduct_name(resultSet.getString("product_name"));
                product.setPrice(Integer.parseInt(resultSet.getString("price")));
                product.setDiscount(Integer.parseInt(resultSet.getString("discount")));
                product.setStock(Integer.parseInt(resultSet.getString("stock")));

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_INSERT_PRODUCT);
            preparedStatement.setString(1,product.getProduct_name());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getDiscount());
            preparedStatement.setInt(4, product.getStock());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
