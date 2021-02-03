package model.service.employee;

import model.bean.Employee;
import model.repo.employee.EmployeeRepoImpl;
import model.service.FuramaService;

import java.util.List;

public class EmployeeServiceImpl implements FuramaService<Employee> {

    EmployeeRepoImpl employeeRepolmpl = new EmployeeRepoImpl();

    @Override
    public List<Employee> findAll() {
        return employeeRepolmpl.findAll();
    }

    @Override
    public Employee selectById(String id) {
        return employeeRepolmpl.selectById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepolmpl.update(employee);
    }

    @Override
    public void delete(String id, String access) {
        if(access.equals("yes")){
            employeeRepolmpl.delete(id);
        }
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepolmpl.searchName(name);
    }

    @Override
    public String add(Employee employee) {

        employeeRepolmpl.add(employee);
        return "";
    }
}
