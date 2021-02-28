package com.wbd.repository;

import com.wbd.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findOne(Long id);

    void save(Customer customer);


    boolean exists(Long id);

    List<Customer> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
