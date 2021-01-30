package model.service;

import model.bean.Customer;

import java.util.List;

public interface FuramaService {
    List<Customer> findAllCustomer();


    void saveCustomer(Customer customer);
}
