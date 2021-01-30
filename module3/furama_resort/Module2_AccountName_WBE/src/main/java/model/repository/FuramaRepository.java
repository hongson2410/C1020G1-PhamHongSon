package model.repository;

import model.bean.Customer;

import java.util.List;

public interface FuramaRepository {
    List<Customer> findAllCustomer();

    void saveCustomer(Customer customer);
}
