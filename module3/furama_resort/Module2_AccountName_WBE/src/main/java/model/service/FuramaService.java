package model.service;

import model.bean.Customer;

import java.util.List;

public interface FuramaService {
    List<Customer> findAllCustomer();

    Customer findCustomerById(String id);

    List<Customer> findCustomerByName(String name);

    void deleteCustomer(int id);

    String saveCustomer(String customer_id, String customer_type_id, String customer_name, String customer_birthday,
                        String customer_gender, String customer_id_card, String customer_phone, String customer_email,
                        String customer_address);
}
