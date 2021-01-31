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

    private static final String SQL_FIND_CUSTOMER_BY_ID = "select * " +
            "from customer " +
            "where customer_id = ?";

    private static final String SQL_DELETE_CUSTOMER = "delete from customer " +
            "where customer_id = ?";

    private static final String SQL_UPDATE_CUSTOMER = "update customer " +
            "set customer_type_id = ? , customer_name = ? , customer_birthday = ? , customer_gender = ?, " +
            "customer_id_card = ? , customer_phone = ? , customer_email = ? , customer_address = ? " +
            "where customer_id = ?";

    private static final String SQL_FIND_CUSTOMER_BY_NAME = "select * " +
            "from customer " +
            "where customer_name like concat('%',?,'%')";

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                customer = new Customer();
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
    public Customer findCustomerById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_CUSTOMER_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int customer_id = Integer.parseInt(resultSet.getString("customer_id"));
            int customer_type_id = Integer.parseInt(resultSet.getString("customer_type_id"));
            String customer_name = resultSet.getString("customer_name");
            String customer_birthday = resultSet.getString("customer_birthday");
            int customer_gender = Integer.parseInt(resultSet.getString("customer_gender"));
            String customer_id_card = resultSet.getString("customer_id_card");
            String customer_phone = resultSet.getString("customer_phone");
            String customer_email = resultSet.getString("customer_email");
            String customer_address = resultSet.getString("customer_address");
            customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card,
                    customer_phone, customer_email, customer_address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
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
    public void deleteCustomer(int id) {
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_DELETE_CUSTOMER);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCustomer(Customer customer) {
        if (customer.getCustomer_id() == null) {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_INSERT_CUSTOMER);
                preparedStatement.setInt(1, customer.getCustomer_type_id());
                preparedStatement.setString(2, customer.getCustomer_name());
                preparedStatement.setString(3, customer.getCustomer_birthday());
                preparedStatement.setInt(4, customer.isCustomer_gender());
                preparedStatement.setString(5, customer.getCustomer_id_card());
                preparedStatement.setString(6, customer.getCustomer_phone());
                preparedStatement.setString(7, customer.getCustomer_email());
                preparedStatement.setString(8, customer.getCustomer_address());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_UPDATE_CUSTOMER);
                preparedStatement.setInt(1, customer.getCustomer_type_id());
                preparedStatement.setString(2, customer.getCustomer_name());
                preparedStatement.setString(3, customer.getCustomer_birthday());
                preparedStatement.setInt(4, customer.isCustomer_gender());
                preparedStatement.setString(5, customer.getCustomer_id_card());
                preparedStatement.setString(6, customer.getCustomer_phone());
                preparedStatement.setString(7, customer.getCustomer_email());
                preparedStatement.setString(8, customer.getCustomer_address());
                preparedStatement.setString(9, String.valueOf(customer.getCustomer_id()));

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
