package model.repo.customer_using_service;

import model.bean.CustomerUsingService;
import model.repo.BaseRepo;
import model.repo.FuramaRepository;
import model.service.FuramaService;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsing implements FuramaRepository<CustomerUsingService> {


    BaseRepo baseRepo = new BaseRepo();


    @Override
    public List<CustomerUsingService> findAll(){

        List<CustomerUsingService> listCustomerUsing = new ArrayList<>();

        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call customer_using_service()");

            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()){
                String customerName = resultSet.getString("customer_name");
                String customerID = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String serviceName = resultSet.getString("service_name");
                String attachServiceName = resultSet.getString("attach_service_name");
                String idService = resultSet.getString("service_id");
                String idServiceType = resultSet.getString("service_type_id");

                CustomerUsingService customerUsingService =
                        new CustomerUsingService
                                (customerName,customerID,customerPhone,serviceName,attachServiceName,idService,idServiceType);

                listCustomerUsing.add(customerUsingService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCustomerUsing;
    }

    @Override
    public CustomerUsingService selectById(String id) {
        return null;
    }

    @Override
    public void update(CustomerUsingService customerUsingService) {

    }

    @Override
    public void delete(String id) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call delete_service(?)");

            callableStatement.setString(1,id);

            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CustomerUsingService> searchName(String name) {
        return null;
    }

    @Override
    public void add(CustomerUsingService customerUsingService) {

    }
}
