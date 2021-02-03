package repository.impl;

import bean.Employee;
import repository.EmployeeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private BaseRepository baseRepository = new BaseRepository();

    private final String SQL_FIND_ALL = "select * " +
            "from employee";

    private final String SQL_FIND_BY_ID = "select * " +
            "from employee " +
            "where employee_id = ?";

    private final String SQL_FIND_BY_NAME = "select * " +
            "from employee " +
            "where employee_name like concat('%',?,'%')";

    private final String SQL_UPDATE = "update employee " +
            "set employee_name = ?, employee_birthday = ?, " +
            "employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, " +
            "employee_address = ?, user_username = ?, position_id = ?, education_degree_id = ?, division_id = ? " +
            "where employee_id = ?";

    private final String SQL_CREATE = "insert into employee(employee_name, employee_birthday, employee_id_card," +
            " employee_salary, employee_phone, employee_email, employee_address, user_username, position_id," +
            " education_degree_id, division_id) values " +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final String SQL_DELETE = "delete from employee " +
            "where employee_id = ?";

    @Override
    public void save(Employee employee) {
        if (employee.getEmployee_id() == null) {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_CREATE);
                preparedStatement.setString(1, employee.getEmployee_name());
                preparedStatement.setString(2, employee.getEmployee_birthday());
                preparedStatement.setString(3, employee.getEmployee_id_card());
                preparedStatement.setString(4, employee.getEmployee_salary());
                preparedStatement.setString(5, employee.getEmployee_phone());
                preparedStatement.setString(6, employee.getEmployee_email());
                preparedStatement.setString(7, employee.getEmployee_address());
                preparedStatement.setString(8, employee.getUser_username());
                preparedStatement.setString(9, employee.getPosition_id());
                preparedStatement.setString(10, employee.getEducation_degree_id());
                preparedStatement.setString(11, employee.getDivision_id());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_UPDATE);
                preparedStatement.setString(1, employee.getEmployee_name());
                preparedStatement.setString(2, employee.getEmployee_birthday());
                preparedStatement.setString(3, employee.getEmployee_id_card());
                preparedStatement.setString(4, employee.getEmployee_salary());
                preparedStatement.setString(5, employee.getEmployee_phone());
                preparedStatement.setString(6, employee.getEmployee_email());
                preparedStatement.setString(7, employee.getEmployee_address());
                preparedStatement.setString(8, employee.getUser_username());
                preparedStatement.setString(9, employee.getPosition_id());
                preparedStatement.setString(10, employee.getEducation_degree_id());
                preparedStatement.setString(11, employee.getDivision_id());
                preparedStatement.setString(12, employee.getEmployee_id());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployee_id(resultSet.getString("employee_id"));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
                employee.setEmployee_salary(resultSet.getString("employee_salary"));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_address(resultSet.getString("employee_address"));
                employee.setUser_username(resultSet.getString("user_username"));
                employee.setPosition_id(resultSet.getString("position_id"));
                employee.setEducation_degree_id(resultSet.getString("education_degree_id"));
                employee.setDivision_id(resultSet.getString("division_id"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = new Employee();

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            employee.setEmployee_id(resultSet.getString("employee_id"));
            employee.setEmployee_name(resultSet.getString("employee_name"));
            employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
            employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
            employee.setEmployee_salary(resultSet.getString("employee_salary"));
            employee.setEmployee_phone(resultSet.getString("employee_phone"));
            employee.setEmployee_email(resultSet.getString("employee_email"));
            employee.setEmployee_address(resultSet.getString("employee_address"));
            employee.setUser_username(resultSet.getString("user_username"));
            employee.setPosition_id(resultSet.getString("position_id"));
            employee.setEducation_degree_id(resultSet.getString("education_degree_id"));
            employee.setDivision_id(resultSet.getString("division_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> employeeList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_BY_NAME);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployee_id(resultSet.getString("employee_id"));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
                employee.setEmployee_salary(resultSet.getString("employee_salary"));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_address(resultSet.getString("employee_address"));
                employee.setUser_username(resultSet.getString("user_username"));
                employee.setPosition_id(resultSet.getString("position_id"));
                employee.setEducation_degree_id(resultSet.getString("education_degree_id"));
                employee.setDivision_id(resultSet.getString("division_id"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(SQL_DELETE);
            preparedStatement.setString(1, String.valueOf(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//
//    @Override
//    public User getUserById(Integer id) {
//        User user = null;
//        String query = "{CALL get_user_by_id(?)}";
//        try {CallableStatement callableStatement =
//                     this.baseRepository.getConnection().prepareCall(query);
//             callableStatement.setString(1, String.valueOf(id));
//            ResultSet rs = callableStatement.executeQuery();
////            while (rs.next()) {
//            rs.next();
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                user = new User(id, name, email, country);
////            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
}
