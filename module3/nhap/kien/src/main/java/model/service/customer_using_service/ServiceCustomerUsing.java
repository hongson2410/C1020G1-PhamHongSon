package model.service.customer_using_service;

import model.bean.CustomerUsingService;
import model.repo.customer_using_service.CustomerUsing;
import model.service.FuramaService;

import java.util.List;

public class ServiceCustomerUsing implements FuramaService<CustomerUsingService> {

    CustomerUsing customerUsing = new CustomerUsing();

    @Override
    public List<CustomerUsingService> findAll() {
        List<CustomerUsingService> list = customerUsing.findAll();

        for(CustomerUsingService customerUsingService : list){
            if (customerUsingService.getAttachService() == null){
                customerUsingService.setAttachService("Không có");
            }
        }
        return list;
    }

    @Override
    public CustomerUsingService selectById(String id) {
        return null;
    }

    @Override
    public void update(CustomerUsingService customerUsingService) {

    }

    @Override
    public void delete(String id, String access) {
        if(access.equals("yes")){
            customerUsing.delete(id);
        }
    }

    @Override
    public List<CustomerUsingService> searchByName(String name) {
        return null;
    }

    @Override
    public String add(CustomerUsingService customerUsingService) {
        return "";
    }
}
