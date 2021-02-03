package model.service.customer;

import model.bean.Customer;
import model.repo.FuramaRepository;
import model.repo.customer.CustomerRepoImpl;
import model.service.FuramaService;
import model.validate.ValidateFurama;

import java.util.List;

public class CustomerServiceImpl implements FuramaService<Customer> {

    CustomerRepoImpl customerRepo = new CustomerRepoImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer selectById(String id) {
        return customerRepo.selectById(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.update(customer);
    }

    @Override
    public void delete(String id, String access) {
        if (access.equals("yes")) {
            customerRepo.delete(id);
        }
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepo.searchName(name);
    }

    @Override
    public String add(Customer customer) {

        String name = customer.getCustomer_name();
        String phone = customer.getCustomer_phone();
        String idCard = customer.getCustomer_id_card();
        String email = customer.getCustomer_email();

        if (!ValidateFurama.nameCustomer(name)) {
            return "Sai định dạng ID(KH-XXXX)";
        } else if (!ValidateFurama.phoneRegex(phone)) {
            return "Sai định dạng sđt (090 | 091 | (84+)91 | (84+)90)";
        } else if (!ValidateFurama.idRegex(idCard)) {
            return "CMND bao gồm 9 số";
        } else if (!ValidateFurama.emailRegex(email)) {
            return "Email định dạng abc@abc.abc";
        }else{
            customerRepo.add(customer);
            return "OK";
        }
    }
    }
