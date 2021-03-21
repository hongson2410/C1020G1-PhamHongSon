package com.codegym.validate;

import com.codegym.models.customer.Customer;
import com.codegym.models.employee.Employee;
import com.codegym.repositories.customer.CustomerRepository;
import com.codegym.repositories.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<DupEmail, Object> {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(Object object,ConstraintValidatorContext context) {
        boolean check = false;
        if (object instanceof Employee) {
            Employee employee = (Employee)object;
            String email = employee.getEmployeeEmail();
            if (employeeRepository.findByEmployeeEmail(email)== null){
                check = true;
            }
        } else if (object instanceof Customer) {
            Customer customer = (Customer)object;
            String email = customer.getCustomerEmail();
            if (customerRepository.findByCustomerEmail(email)==null){
                check= true;
            }
        }
        return check;
    }
}
