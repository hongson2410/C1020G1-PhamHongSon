package com.codegym.services;

import com.codegym.models.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable);

    List<Employee> findByEmployeeNameContaining(String employeeName);

    Employee findEmployeeById(Integer id);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(Integer id);
}
