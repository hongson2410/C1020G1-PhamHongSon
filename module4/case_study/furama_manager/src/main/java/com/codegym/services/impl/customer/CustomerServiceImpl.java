package com.codegym.services.impl.customer;

import com.codegym.models.customer.Customer;
import com.codegym.repositories.customer.CustomerRepository;
import com.codegym.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findByCustomerNameContaining(String customerName) {
        return customerRepository.findByCustomerNameContainingOrCustomerPhoneContainingOrCustomerCodeContaining(customerName,customerName,customerName);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
