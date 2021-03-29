package com.codegym.services;

import com.codegym.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomer();

    List<Customer> findByCustomerNameContaining(String customerName);

    Customer findCustomerById(Integer id);

    void deleteCustomer(Integer id);
}
