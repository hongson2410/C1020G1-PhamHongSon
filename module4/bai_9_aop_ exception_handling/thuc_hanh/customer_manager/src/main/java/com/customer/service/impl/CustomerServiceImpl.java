package com.customer.service.impl;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.customer.service.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllByLastNameContaining(String lastName, Pageable pageable) throws Exception {
        return customerRepository.findAllByLastNameContaining(lastName, pageable);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) throws Exception {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(int id) throws Exception {
        Customer customer = customerRepository.findById(id).orElse(null);
        return customer;
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
