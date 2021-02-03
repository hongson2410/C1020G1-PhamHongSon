package model.repo.customer;

import model.bean.Customer;
import model.repo.BaseRepo;
import model.repo.FuramaRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepoImpl implements FuramaRepository<Customer> {

    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_all_customer()");

            ResultSet resultSet = callableStatement.executeQuery();

            Customer customer;
            while (resultSet.next()){
                customer = new Customer();
                customer.setCustomer_id(resultSet.getString("customer_id"));
                customer.setCustomer_type(resultSet.getInt("customer_type"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getInt("customer_gender"));
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
    public Customer selectById(String id) {
        Customer customer = new Customer();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_customer_by_id(?)");
            callableStatement.setString(1,id);

            ResultSet resultSet = callableStatement.executeQuery();

            resultSet.next();

            customer.setCustomer_type(resultSet.getInt("customer_type"));
            customer.setCustomer_name(resultSet.getString("customer_name"));
            customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
            customer.setCustomer_gender(resultSet.getInt("customer_gender"));
            customer.setCustomer_phone(resultSet.getString("customer_phone"));
            customer.setCustomer_email(resultSet.getString("customer_email"));
            customer.setCustomer_address(resultSet.getString("customer_address"));
            customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call update_customer(?,?,?,?,?,?,?,?,?)");
            callableStatement.setString(1,customer.getCustomer_id());
            callableStatement.setString(2,customer.getCustomer_name());
            callableStatement.setInt(3,customer.getCustomer_type());
            callableStatement.setString(4,customer.getCustomer_birthday());
            callableStatement.setInt(5,customer.getCustomer_gender());
            callableStatement.setString(6,customer.getCustomer_id_card());
            callableStatement.setString(7,customer.getCustomer_phone());
            callableStatement.setString(8,customer.getCustomer_email());
            callableStatement.setString(9,customer.getCustomer_address());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call delete_customer(?)");
            callableStatement.setString(1,id);
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> searchName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call search_customer(?)");
            callableStatement.setString(1,name);

            ResultSet resultSet = callableStatement.executeQuery();

            Customer customer;
            while (resultSet.next()){
                customer = new Customer();
                customer.setCustomer_type(resultSet.getInt("customer_type"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getInt("customer_gender"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  customerList;
    }

    @Override
    public void add(Customer customer) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call add_new_customer(?,?,?,?,?,?,?,?,?)");
            callableStatement.setString(1,String.valueOf(customer.getCustomer_id()));
            callableStatement.setString(2,String.valueOf(customer.getCustomer_type()));
            callableStatement.setString(3,customer.getCustomer_name());
            callableStatement.setString(4,customer.getCustomer_birthday());
            callableStatement.setString(5,String.valueOf(customer.getCustomer_gender()));
            callableStatement.setString(6,customer.getCustomer_id_card());
            callableStatement.setString(7,customer.getCustomer_phone());
            callableStatement.setString(8,customer.getCustomer_email());
            callableStatement.setString(9,customer.getCustomer_address());
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
