package model.repository;

import model.bean.Customer;

import java.util.List;

public interface FuramaRepository {
    List<Customer> findAllCustomer();

    Customer findCustomerById(int id);

    List<Customer> findCustomerByName(String name);

    void deleteCustomer(int id);

    void saveCustomer(Customer customer);
}
