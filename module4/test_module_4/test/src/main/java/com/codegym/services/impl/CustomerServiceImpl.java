package com.codegym.services.impl;

import com.codegym.models.Customer;
import com.codegym.repositories.CustomerRepository;
import com.codegym.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByCustomerNameContaining(String customerName) {
        return null;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return null;
    }

    @Override
    public void deleteCustomer(Integer id) {

    }
}
