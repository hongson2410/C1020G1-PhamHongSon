package model.repository;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;

import java.util.List;

public interface FuramaRepository {
    List<Customer> findAllCustomer();

    Customer findCustomerById(int id);

    List<Customer> findCustomerByName(String name);

    void deleteCustomer(int id);

    void saveCustomer(Customer customer);

    List<Employee> findAllEmployee();

    Employee findEmployeeById(int id);

    List<Employee> findEmployeeByName(String name);

    void deleteEmployee(int id);

    void saveEmployee(Employee employee);

    void saveService(Service service);
}
