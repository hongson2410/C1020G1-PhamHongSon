package repository;

import bean.Employee;

import java.util.List;

public interface EmployeeRepository {

    void save(Employee employee);
    List<Employee> findAll();
    Employee findById(Integer id);
    List<Employee> findByName(String name);
    void deleteById(Integer id);
//    User getUserById(Integer id);
}
