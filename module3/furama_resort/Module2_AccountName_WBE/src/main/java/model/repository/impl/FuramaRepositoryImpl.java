package model.repository.impl;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.repository.FuramaRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuramaRepositoryImpl implements FuramaRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private static final String SQL_INSERT_CUSTOMER = "INSERT INTO customer (customer_type_id, customer_name, " +
            "customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) " +
            " VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_INSERT_SERVICE = "insert into service (service_name, service_area, service_cost, " +
            "service_max_people,rent_type_id, service_type_id, standard_room,description_other_convenience, pool_area, " +
            "number_floors) " +
            " values (?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_FIND_ALL_CUSTOMER = "select * " +
            "from customer";

    private static final String SQL_FIND_CUSTOMER_BY_ID = "select * " +
            "from customer " +
            "where customer_id = ?";

    private static final String SQL_DELETE_CUSTOMER = "delete from customer " +
            "where customer_id = ?";

    private static final String SQL_UPDATE_CUSTOMER = "update customer " +
            "set customer_type_id = ? , customer_name = ? , customer_birthday = ? , customer_gender = ?, " +
            "customer_id_card = ? , customer_phone = ? , customer_email = ? , customer_address = ? " +
            "where customer_id = ?";

    private static final String SQL_FIND_CUSTOMER_BY_NAME = "select * " +
            "from customer " +
            "where customer_name like concat('%',?,'%')";

    private static final String SQL_FIND_ALL_EMPLOYEE="select * " +
            "from employee";

    private static final String SQL_INSERT_EMPLOYEE = "Insert into employee ( employee_name,  employee_birthday,  " +
            "employee_id_card,  employee_salary,employee_phone,  employee_email,  employee_address,  position_id," +
            "education_degree_id,  division_id ) " +
            "values (?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE_EMPLOYEE= "update employee " +
            "set employee_name=?,  employee_birthday=? ,employee_id_card=? ,  employee_salary=? ,employee_phone=? ," +
            "employee_email= ?,employee_address = ?,  position_id=? ,education_degree_id=? ,  division_id= ? " +
            "where employee_id=?";

    private static final String SQL_FIND_EMPLOYEE_BY_ID ="select * " +
            "from employee " +
            "where employee_id = ?";

    private static final String SQL_DELETE_EMPLOYEE = "delete from employee " +
            "where employee_id=?";

    private static final String SQL_FIND_EMPLOYEE_BY_NAME= "select * " +
            "from employee " +
            "where employee_name like concat ('%',?,'%')";


    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomer_id(Integer.parseInt(resultSet.getString("customer_id")));
                customer.setCustomer_type_id(Integer.parseInt(resultSet.getString("customer_type_id")));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(Integer.parseInt(resultSet.getString("customer_gender")));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findCustomerById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_CUSTOMER_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int customer_id = Integer.parseInt(resultSet.getString("customer_id"));
            int customer_type_id = Integer.parseInt(resultSet.getString("customer_type_id"));
            String customer_name = resultSet.getString("customer_name");
            String customer_birthday = resultSet.getString("customer_birthday");
            int customer_gender = Integer.parseInt(resultSet.getString("customer_gender"));
            String customer_id_card = resultSet.getString("customer_id_card");
            String customer_phone = resultSet.getString("customer_phone");
            String customer_email = resultSet.getString("customer_email");
            String customer_address = resultSet.getString("customer_address");
            customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card,
                    customer_phone, customer_email, customer_address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(Integer.parseInt(resultSet.getString("customer_id")));
                customer.setCustomer_type_id(Integer.parseInt(resultSet.getString("customer_type_id")));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(Integer.parseInt(resultSet.getString("customer_gender")));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_DELETE_CUSTOMER);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCustomer(Customer customer) {
        if (customer.getCustomer_id() == null) {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_INSERT_CUSTOMER);
                preparedStatement.setInt(1, customer.getCustomer_type_id());
                preparedStatement.setString(2, customer.getCustomer_name());
                preparedStatement.setString(3, customer.getCustomer_birthday());
                preparedStatement.setInt(4, customer.isCustomer_gender());
                preparedStatement.setString(5, customer.getCustomer_id_card());
                preparedStatement.setString(6, customer.getCustomer_phone());
                preparedStatement.setString(7, customer.getCustomer_email());
                preparedStatement.setString(8, customer.getCustomer_address());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_UPDATE_CUSTOMER);
                preparedStatement.setInt(1, customer.getCustomer_type_id());
                preparedStatement.setString(2, customer.getCustomer_name());
                preparedStatement.setString(3, customer.getCustomer_birthday());
                preparedStatement.setInt(4, customer.isCustomer_gender());
                preparedStatement.setString(5, customer.getCustomer_id_card());
                preparedStatement.setString(6, customer.getCustomer_phone());
                preparedStatement.setString(7, customer.getCustomer_email());
                preparedStatement.setString(8, customer.getCustomer_address());
                preparedStatement.setString(9, String.valueOf(customer.getCustomer_id()));

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployee_id(Integer.parseInt(resultSet.getString("employee_id")));
               employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
                employee.setEmployee_salary(Double.parseDouble(resultSet.getString("employee_salary")));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_address(resultSet.getString("employee_address"));
                employee.setPosition_id(Integer.parseInt(resultSet.getString("position_id")));
                employee.setEducation_degree_id(Integer.parseInt(resultSet.getString("education_degree_id")));
                employee.setDivision_id(Integer.parseInt(resultSet.getString("division_id")));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee employee = new Employee();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_EMPLOYEE_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee.setEmployee_id(Integer.parseInt(resultSet.getString("employee_id")));
            employee.setEmployee_name(resultSet.getString("employee_name"));
            employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
            employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
            employee.setEmployee_salary(Double.parseDouble(resultSet.getString("employee_salary")));
            employee.setEmployee_phone(resultSet.getString("employee_phone"));
            employee.setEmployee_email(resultSet.getString("employee_email"));
            employee.setEmployee_address(resultSet.getString("employee_address"));
            employee.setPosition_id(Integer.parseInt(resultSet.getString("position_id")));
            employee.setEducation_degree_id(Integer.parseInt(resultSet.getString("education_degree_id")));
            employee.setDivision_id(Integer.parseInt(resultSet.getString("division_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_EMPLOYEE_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(Integer.parseInt(resultSet.getString("employee_id")));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
                employee.setEmployee_salary(Double.parseDouble(resultSet.getString("employee_salary")));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_address(resultSet.getString("employee_address"));
                employee.setPosition_id(Integer.parseInt(resultSet.getString("position_id")));
                employee.setEducation_degree_id(Integer.parseInt(resultSet.getString("education_degree_id")));
                employee.setDivision_id(Integer.parseInt(resultSet.getString("division_id")));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_DELETE_EMPLOYEE);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEmployee(Employee employee) {
        if (employee.getEmployee_id() == null) {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_INSERT_EMPLOYEE);
                preparedStatement.setString(1, employee.getEmployee_name());
                preparedStatement.setString(2, employee.getEmployee_birthday());
                preparedStatement.setString(3, employee.getEmployee_id_card());
                preparedStatement.setDouble(4, employee.getEmployee_salary());
                preparedStatement.setString(5, employee.getEmployee_phone());
                preparedStatement.setString(6, employee.getEmployee_email());
                preparedStatement.setString(7, employee.getEmployee_address());
                preparedStatement.setInt(8, employee.getPosition_id());
                preparedStatement.setInt(9, employee.getEducation_degree_id());
                preparedStatement.setInt(10, employee.getDivision_id());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_UPDATE_EMPLOYEE);
                preparedStatement.setString(1, employee.getEmployee_name());
                preparedStatement.setString(2, employee.getEmployee_birthday());
                preparedStatement.setString(3, employee.getEmployee_id_card());
                preparedStatement.setDouble(4, employee.getEmployee_salary());
                preparedStatement.setString(5, employee.getEmployee_phone());
                preparedStatement.setString(6, employee.getEmployee_email());
                preparedStatement.setString(7, employee.getEmployee_address());
                preparedStatement.setInt(8, employee.getPosition_id());
                preparedStatement.setInt(9, employee.getEducation_degree_id());
                preparedStatement.setInt(10, employee.getDivision_id());
                preparedStatement.setString(11, String.valueOf(employee.getEmployee_id()));

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveService(Service service) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SQL_INSERT_SERVICE);
            preparedStatement.setString(1, service.getService_name());
            preparedStatement.setInt(2, service.getService_area());
            preparedStatement.setDouble(3, service.getService_cost());
            preparedStatement.setInt(4, service.getService_max_people());
            preparedStatement.setInt(5, service.getRent_type_id());
            preparedStatement.setInt(6, service.getService_type_id());
            preparedStatement.setString(7, service.getStandard_room());
            preparedStatement.setString(8, service.getDescription_other_convenience());
            preparedStatement.setDouble(9, service.getPool_area());
            preparedStatement.setInt(10, service.getNumber_floors());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
