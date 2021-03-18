package com.codegym.services.impl.employee;

import com.codegym.models.employee.Employee;
import com.codegym.models.employee.FuramaRole;
import com.codegym.models.employee.FuramaRoleUser;
import com.codegym.models.employee.FuramaUser;
import com.codegym.repositories.employee.EmployeeRepository;
import com.codegym.repositories.login.FuramaRoleRepository;
import com.codegym.repositories.login.FuramaRoleUserRepository;
import com.codegym.repositories.login.FuramaUserRepository;
import com.codegym.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    FuramaRoleUserRepository furamaRoleUserRepository;

    @Autowired
    FuramaUserRepository furamaUserRepository;

    @Autowired
    FuramaRoleRepository furamaRoleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findByEmployeeNameContaining(String employeeName) {
        return employeeRepository.findByEmployeeNameContaining(employeeName);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEmployee(Employee employee) {
        FuramaUser furamaUser= new FuramaUser();
        furamaUser.setUserName(employee.getEmployeeEmail());
        furamaUser.setPassword(passwordEncoder.encode("123456"));
        furamaUserRepository.save(furamaUser);

        if (employee.getPosition().getPositionId()==5 || employee.getPosition().getPositionId()==6){
            FuramaRole furamaRole = furamaRoleRepository.findById(1).orElse(null);

            FuramaRoleUser furamaRoleUser = new FuramaRoleUser();
            furamaRoleUser.setFuramaRole(furamaRole);
            furamaRoleUser.setFuramaUser(furamaUser);
        }else {
            FuramaRole furamaRole = furamaRoleRepository.findById(2).orElse(null);

            FuramaRoleUser furamaRoleUser = new FuramaRoleUser();
            furamaRoleUser.setFuramaUser(furamaUser);
            furamaRoleUser.setFuramaRole(furamaRole);

            furamaRoleUserRepository.save(furamaRoleUser);
        }
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
