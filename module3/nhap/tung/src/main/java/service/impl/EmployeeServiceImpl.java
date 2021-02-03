package service.impl;

import bean.Employee;
import repository.EmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.EmployeeService;
import service.function.Input;
import service.function.Regex;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private Regex regex = new Regex();
    private Input input = new Input();
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public String save(Employee employee) {
        if (!regex.regexName(employee.getEmployee_name())) {
            if (!input.inputString(employee.getEmployee_name())) {
                return "Name must have value";
            }
            return "Wrong format Name";
        }

        if (!regex.regexBirthday(employee.getEmployee_birthday())) {
            if (!input.inputString(employee.getEmployee_birthday())) {
                return "Birthday must have value";
            }
            return "Wrong format Date";
        }

        if (!regex.regexIdNumber(employee.getEmployee_id_card())) {
            if (!input.inputInt(employee.getEmployee_id_card())) {
                if (!input.inputString(employee.getEmployee_id_card())) {
                    return "ID Card must have value";
                }
                return "ID Card Number must have all numbers";
            }
            return "Wrong format ID Card Number";
        }

        if (!input.inputDouble(employee.getEmployee_salary())) {
            if (!input.inputString(employee.getEmployee_salary())) {
                return "Salary must have value";
            }
            return "Wrong format Salary";
        }

        if (!regex.regexPhoneNumber(employee.getEmployee_phone())) {
            if (!input.inputString(employee.getEmployee_phone())) {
                return "Phone must have value";
            }
            return "Wrong format Phone Number";
        }

        if (!regex.regexEmail(employee.getEmployee_email())) {
            if (!input.inputString(employee.getUser_username())){
                return "Email must have value";
            }
            return "Wrong format Email";
        }

        if (!input.inputString(employee.getUser_username())){
            return "Username must have value";
        }

        if (!input.inputString(employee.getPosition_id())) {
            employee.setPosition_id("7");
        } else if (!input.inputInt(employee.getPosition_id())) {
            return "Wrong format Position";
        }

        if (!input.inputString(employee.getEducation_degree_id())) {
            employee.setEducation_degree_id("5");
        } else if (!input.inputInt(employee.getEducation_degree_id())) {
            return "Wrong format Education Degree";
        }

        if (!input.inputString(employee.getDivision_id())) {
            employee.setDivision_id("5");
        } else if (!input.inputInt(employee.getDivision_id())) {
            return "Wrong format Division";
        }

        employeeRepository.save(employee);
        return "OK";
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
//
//    @Override
//    public User getUserById(Integer id) {
//        return null;
//    }
}
