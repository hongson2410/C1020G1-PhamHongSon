package model.repository.impl;

import model.bean.Customer;
import model.repository.FuramaRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuramaRepositoryImpl implements FuramaRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private static final String SQL_INSERT_CUSTOMER = "INSERT INTO customer (customer_type_id, customer_name, " +
            "customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) " +
            " VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_FIND_ALL_CUSTOMER = "select * " +
            "from customer";

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()){
                customer=new Customer();
                customer.setCustomer_id(Integer.parseInt(resultSet.getString("customer_id")));
                customer.setCustomer_type_id(Integer.parseInt(resultSet.getString("customer_type_id")));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(Integer.parseInt(resultSet.getString("customer_gender")));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void saveCustomer(Customer customer) {
        if (customer.getCustomer_id() == null) {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_INSERT_CUSTOMER);
                preparedStatement.setInt(1,customer.getCustomer_type_id());
                preparedStatement.setString(2, customer.getCustomer_name());
                preparedStatement.setString(3, customer.getCustomer_birthday());
                preparedStatement.setInt(4,customer.isCustomer_gender());
                preparedStatement.setString(5, customer.getCustomer_id_card());
                preparedStatement.setString(6, customer.getCustomer_phone());
                preparedStatement.setString(7, customer.getCustomer_email());
                preparedStatement.setString(8, customer.getCustomer_address());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
//            try {
//                PreparedStatement preparedStatement =
//                        this.baseRepository.getConnection().prepareStatement(SQL_UPDATE);
//                preparedStatement.setString(1, user.getName());
//                preparedStatement.setString(2, user.getEmail());
//                preparedStatement.setString(3, user.getCountry());
//                preparedStatement.setString(4, String.valueOf(user.getId()));
//
//                preparedStatement.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
    }
}
