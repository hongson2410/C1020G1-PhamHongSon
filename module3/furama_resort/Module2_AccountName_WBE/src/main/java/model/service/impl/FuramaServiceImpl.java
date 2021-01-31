package model.service.impl;

import model.bean.Customer;
import model.repository.FuramaRepository;
import model.repository.impl.FuramaRepositoryImpl;
import model.service.FuramaService;

import java.util.List;

public class FuramaServiceImpl implements FuramaService {
    FuramaRepository furamaRepository = new FuramaRepositoryImpl();

    @Override
    public String saveCustomer(String customer_id, String customer_type_id, String customer_name, String customer_birthday,
                               String customer_gender, String customer_id_card, String customer_phone, String customer_email,
                               String customer_address) {
        Customer customer;
        if (customer_type_id.equals("") || customer_name.equals("") || customer_birthday.equals("") || customer_gender.equals("")
                || customer_id_card.equals("") || customer_phone.equals("") || customer_email.equals("") || customer_address.equals("")) {
            return "Please Input";
        }
        if (customer_id.equals("")) {
            customer = new Customer(Integer.parseInt(customer_type_id), customer_name,
                    customer_birthday, Integer.parseInt(customer_gender), customer_id_card, customer_phone, customer_email,
                    customer_address);
        } else {
            customer = new Customer(Integer.parseInt(customer_id), Integer.parseInt(customer_type_id), customer_name,
                    customer_birthday, Integer.parseInt(customer_gender), customer_id_card, customer_phone, customer_email,
                    customer_address);
        }
        furamaRepository.saveCustomer(customer);
        return "Customer was update";
    }

    @Override
    public List<Customer> findAllCustomer() {
        return furamaRepository.findAllCustomer();
    }

    @Override
    public Customer findCustomerById(String id) {
        Customer customer = null;
        if (id.matches("\\d*")) {
            return furamaRepository.findCustomerById(Integer.parseInt(id));
        }
        return customer;
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return furamaRepository.findCustomerByName(name);
    }

    @Override
    public void deleteCustomer(int id) {
        furamaRepository.deleteCustomer(id);
    }
}
