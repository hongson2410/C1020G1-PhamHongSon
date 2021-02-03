package service;

import bean.Employee;

import java.util.List;

public interface EmployeeService {

    String save(Employee employee);
    List<Employee> findAll();
        Employee findById(Integer id);
    List<Employee> findByName(String name);
    void deleteById(Integer id);
//    User getUserById(Integer id);
}
