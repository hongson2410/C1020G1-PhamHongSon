package model.service.impl;

import model.bean.Customer;
import model.repository.FuramaRepository;
import model.repository.impl.FuramaRepositoryImpl;
import model.service.FuramaService;

import java.util.List;

public class FuramaServiceImpl implements FuramaService {
    FuramaRepository furamaRepository = new FuramaRepositoryImpl();

    @Override
    public void saveCustomer(Customer customer) {
    furamaRepository.saveCustomer(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return furamaRepository.findAllCustomer();
    }
}
