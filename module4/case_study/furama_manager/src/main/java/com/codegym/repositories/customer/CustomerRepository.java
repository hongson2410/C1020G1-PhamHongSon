package com.codegym.repositories.customer;

import com.codegym.models.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerNameContainingOrCustomerPhoneContainingOrCustomerCodeContaining(String customerName,
                                                                                                 String customerPhone,
                                                                                                 String customerCode);

    Customer findByCustomerEmail(String email);
}
