package com.codegym.services;

import com.codegym.models.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

    List<Customer> findByCustomerNameContaining(String customerName);

    Customer findCustomerById(Integer id);

    void saveCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
