package com.codegym.services;

import com.codegym.models.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable);

    Employee findEmployeeById(Integer id);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(Integer id);
}
