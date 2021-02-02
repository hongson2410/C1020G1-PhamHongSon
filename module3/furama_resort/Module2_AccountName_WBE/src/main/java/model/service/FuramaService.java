package model.service;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;

import java.util.List;

public interface FuramaService {
    List<Customer> findAllCustomer();

    Customer findCustomerById(String id);

    List<Customer> findCustomerByName(String name);

    void deleteCustomer(int id);

    String saveCustomer(String customer_id, String customer_code, String customer_type_id, String customer_name, String customer_birthday,
                        String customer_gender, String customer_id_card, String customer_phone, String customer_email,
                        String customer_address);

    List<Employee> findAllEmployee();

    Employee findEmployeeById(String id);

    List<Employee> findEmployeeByName(String name);

    void deleteEmployee(int id);

    String saveEmployee(String employee_id, String employee_name, String employee_birthday, String employee_id_card, String employee_salary,
                        String employee_phone, String employee_email, String employee_address, String position_id,
                        String education_degree_id, String division_id);

    String saveService(String service_code,String service_name, String service_area, String service_cost,
                     String service_max_people, String rent_type_id, String service_type_id, String standard_room,
                     String description_other_convenience, String pool_area, String number_floors);
}
