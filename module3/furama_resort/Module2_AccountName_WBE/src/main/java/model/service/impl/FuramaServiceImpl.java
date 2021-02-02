package model.service.impl;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.repository.FuramaRepository;
import model.repository.impl.FuramaRepositoryImpl;
import model.service.FuramaService;

import java.util.List;

public class FuramaServiceImpl implements FuramaService {
    FuramaRepository furamaRepository = new FuramaRepositoryImpl();

    @Override
    public String saveCustomer(String customer_id, String customer_code, String customer_type_id, String customer_name, String customer_birthday,
                               String customer_gender, String customer_id_card, String customer_phone, String customer_email,
                               String customer_address) {
        Customer customer;
        if (customer_code.equals("") || customer_name.equals("") || customer_birthday.equals("")
                || customer_id_card.equals("") || customer_phone.equals("")) {
            return "Please Input!!!";
        }
        if (customer_id.equals("")) {
            customer = new Customer(customer_code, Integer.parseInt(customer_type_id), customer_name,
                    customer_birthday, Integer.parseInt(customer_gender), customer_id_card, customer_phone, customer_email,
                    customer_address);
            furamaRepository.saveCustomer(customer);
            return "Customer was create";
        } else {
            customer = new Customer(Integer.parseInt(customer_id), customer_code, Integer.parseInt(customer_type_id), customer_name,
                    customer_birthday, Integer.parseInt(customer_gender), customer_id_card, customer_phone, customer_email,
                    customer_address);
            furamaRepository.saveCustomer(customer);
            return "Customer was update";
        }
    }

    @Override
    public List<Customer> findAllCustomer() {
        return furamaRepository.findAllCustomer();
    }

    @Override
    public Customer findCustomerById(String id) {
        Customer customer = null;
        if (id.matches("\\d*")) {
            return furamaRepository.findCustomerById(Integer.parseInt(id));
        }
        return customer;
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return furamaRepository.findCustomerByName(name);
    }

    @Override
    public void deleteCustomer(int id) {
        furamaRepository.deleteCustomer(id);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return furamaRepository.findAllEmployee();
    }

    @Override
    public Employee findEmployeeById(String id) {
        Employee employee = null;
        if (id.matches("\\d*")) {
            return furamaRepository.findEmployeeById(Integer.parseInt(id));
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return furamaRepository.findEmployeeByName(name);
    }

    @Override
    public void deleteEmployee(int id) {
        furamaRepository.deleteEmployee(id);
    }

    @Override
    public String saveEmployee(String employee_id, String employee_name, String employee_birthday, String employee_id_card,
                               String employee_salary, String employee_phone, String employee_email,
                               String employee_address, String position_id, String education_degree_id,
                               String division_id) {
        Employee employee;
        if (employee_name.equals("") || employee_birthday.equals("") || employee_id_card.equals("") ||
                employee_salary.equals("") || employee_phone.equals("") || position_id.equals("") ||
                education_degree_id.equals("") || division_id.equals("")) {
            return "Please Input!!!";
        }
        if (!employee_salary.matches("\\d*[.]\\d*") || !position_id.matches("\\d*") ||
                !education_degree_id.matches("\\d*") || !division_id.matches("\\d*")) {
            return "Please Input Number!!!";
        }
        if (employee_id.equals("")) {
            employee = new Employee(employee_name, employee_birthday, employee_id_card, Double.parseDouble(employee_salary),
                    employee_phone, employee_email, employee_address, Integer.parseInt(position_id), Integer.parseInt(education_degree_id),
                    Integer.parseInt(division_id));
        } else {
            employee = new Employee(Integer.parseInt(employee_id), employee_name, employee_birthday, employee_id_card,
                    Double.parseDouble(employee_salary), employee_phone, employee_email, employee_address,
                    Integer.parseInt(position_id), Integer.parseInt(education_degree_id),
                    Integer.parseInt(division_id));
        }
        furamaRepository.saveEmployee(employee);
        return "Employee was update";
    }

    @Override
    public String saveService(String service_code, String service_name, String service_area, String service_cost,
                              String service_max_people, String rent_type_id, String service_type_id, String standard_room,
                              String description_other_convenience, String pool_area, String number_floors) {
        Service service;
        if (service_code.equals("") || service_name.equals("") || service_area.equals("") || service_cost.equals("") || service_max_people.equals("")
                || rent_type_id.equals("") || service_type_id.equals("") || standard_room.equals("") || pool_area.equals("")
                || description_other_convenience.equals("") || number_floors.equals("")) {
            return "Please Input!!!";
        }
        if (!service_cost.matches("\\d*[.]\\d*") || !service_area.matches("\\d*") ||
                !service_max_people.matches("\\d*") || !service_type_id.matches("\\d*")
                || !rent_type_id.matches("\\d*") || !pool_area.matches("\\d*[.]\\d*")
                || !number_floors.matches("\\d*")) {
            return "Please Input Number!!!";
        }
        service = new Service(service_code, service_name, Integer.parseInt(service_area), Double.parseDouble(service_cost),
                Integer.parseInt(service_max_people), Integer.parseInt(rent_type_id), Integer.parseInt(service_type_id),
                standard_room, description_other_convenience, Double.parseDouble(pool_area), Integer.parseInt(number_floors));
        furamaRepository.saveService(service);
        return "Service was update";
    }
}
