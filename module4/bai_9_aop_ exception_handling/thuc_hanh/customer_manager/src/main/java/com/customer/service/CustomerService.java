package com.customer.service;

import com.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable) throws Exception;
    Customer findById(int id)  throws Exception;
    void save(Customer customer) throws DuplicateEmailException;
    void delete(int id);
    Page<Customer> findAllByLastNameContaining(String lastName, Pageable pageable) throws Exception;
}
