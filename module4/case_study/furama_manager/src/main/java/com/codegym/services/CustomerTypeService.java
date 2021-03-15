package com.codegym.services;

import com.codegym.models.customer.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAllCustomerType();
}
