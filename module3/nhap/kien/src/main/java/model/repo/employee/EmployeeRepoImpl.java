package model.repo.employee;

import model.bean.Employee;
import model.repo.BaseRepo;
import model.repo.FuramaRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoImpl implements FuramaRepository<Employee> {

    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_all_employee()");

            ResultSet resultSet = callableStatement.executeQuery();

            Employee employee;
            while (resultSet.next()){
                employee = new Employee();
                employee.setEmployee_salary(Double.parseDouble(resultSet.getString("employee_salary")));
                employee.setEmployee_id(resultSet.getString("employee_id"));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_gender(resultSet.getInt("employee_gender"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_position(resultSet.getInt("position_id"));
                employee.setEmployee_address(resultSet.getString("employee_address"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public Employee selectById(String id) {
        Employee employee = new Employee();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_employee_by_id(?)");
            callableStatement.setString(1,id);

            ResultSet resultSet = callableStatement.executeQuery();

            resultSet.next();

            employee.setEmployee_position(resultSet.getInt("position_id"));
            employee.setEmployee_name(resultSet.getString("employee_name"));
            employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
            employee.setEmployee_gender(resultSet.getInt("employee_gender"));
            employee.setEmployee_phone(resultSet.getString("employee_phone"));
            employee.setEmployee_email(resultSet.getString("employee_email"));
            employee.setEmployee_address(resultSet.getString("employee_address"));
            employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
            employee.setEmployee_salary(resultSet.getDouble("employee_salary"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call update_employee(?,?,?,?,?,?,?,?,?,?)");
            callableStatement.setString(1,employee.getEmployee_id());
            callableStatement.setString(2,employee.getEmployee_name());
            callableStatement.setInt(3,employee.getEmployee_position());
            callableStatement.setString(4,employee.getEmployee_birthday());
            callableStatement.setInt(5,employee.getEmployee_gender());
            callableStatement.setString(6,employee.getEmployee_id_card());
            callableStatement.setString(7,employee.getEmployee_phone());
            callableStatement.setString(8,employee.getEmployee_email());
            callableStatement.setString(9,employee.getEmployee_address());
            callableStatement.setDouble(10,employee.getEmployee_salary());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call delete_employee(?)");
            callableStatement.setString(1,id);
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> searchName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call search_employee(?)");
            callableStatement.setString(1,name);

            ResultSet resultSet = callableStatement.executeQuery();

            Employee employee;
            while (resultSet.next()){
                employee = new Employee();
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_gender(resultSet.getInt("employee_gender"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_position(resultSet.getInt("position_id"));
                employee.setEmployee_address(resultSet.getString("employee_address"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  employeeList;
    }

    @Override
    public void add(Employee employee) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call add_new_employee(?,?,?,?,?,?,?,?,?,?)");
            callableStatement.setString(1,String.valueOf(employee.getEmployee_id()));
            callableStatement.setString(2,employee.getEmployee_name());
            callableStatement.setString(3,employee.getEmployee_birthday());
            callableStatement.setString(4,String.valueOf(employee.getEmployee_gender()));
            callableStatement.setString(5,employee.getEmployee_id_card());
            callableStatement.setString(6,String.valueOf(employee.getEmployee_salary()));
            callableStatement.setString(7,employee.getEmployee_phone());
            callableStatement.setString(8,employee.getEmployee_email());
            callableStatement.setString(9,employee.getEmployee_address());
            callableStatement.setString(10,String.valueOf(employee.getEmployee_position()));
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
