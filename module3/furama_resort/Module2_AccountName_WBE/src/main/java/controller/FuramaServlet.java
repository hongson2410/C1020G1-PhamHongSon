package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.service.FuramaService;
import model.service.impl.FuramaServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FuramaServlet", urlPatterns = {"", "/furamaServlet"})
public class FuramaServlet extends HttpServlet {
    FuramaService furamaService = new FuramaServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        switch (actionUser) {
            case "create":
                createCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "createEmployee":
                createEmployee(request, response);
                break;
            case "updateEmployee":
                updateEmployee(request, response);
                break;
            case "deleteEmployee":
                deleteEmployee(request, response);
                break;
            case "createService":
                createService(request,response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "create":
                showFormCreateCustomer(request, response);
                break;
            case "delete":
                showFormDeleteCustomer(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
            case "searchById":
                searchCustomerById(request, response);
                break;
            case "searchByName":
                searchCustomerByName(request, response);
                break;
            case "listCustomer":
                loadListCustomer(request, response);
                break;
            case "listEmployee":
                loadListEmployee(request, response);
                break;
            case "createEmployee":
                showFormCreateEmployee(request, response);
                break;
            case "updateEmployee":
                showFormUpdateEmployee(request, response);
                break;
            case "deleteEmployee":
                showFormDeleteEmployee(request, response);
                break;
            case "searchEmployeeById":
                searchEmployeeById(request, response);
                break;
            case "searchEmployeeByName":
                searchEmployeeByName(request, response);
                break;
            case "createService":
                showFormCreateService(request,response);
                break;
            default:
                loadHome(request, response);
                break;
        }
    }

    private void loadHome(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String msg;
        if (name.equals("")) {
            msg = "Please Input!!!";
            request.setAttribute("message", msg);
        } else {
            List<Customer> customerList = furamaService.findCustomerByName(name);
            if (customerList.isEmpty()) {
                msg = "Not Found";
                request.setAttribute("message", msg);
            } else {
                request.setAttribute("customerListFromServlet", customerList);
            }
        }
        try {
            request.getRequestDispatcher("search_customer_by_name.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchCustomerById(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String msg;
        if (id.equals("")) {
            msg = "Please Input!!";
            request.setAttribute("message", msg);
        } else {
            Customer customer = furamaService.findCustomerById(id);
            if (customer == null || customer.getCustomer_name() == null) {
                msg = "Not Found";
                request.setAttribute("message", msg);
            } else {
                request.setAttribute("customerInfo", customer);
            }
        }
        try {
            request.getRequestDispatcher("search_customer_by_id.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = furamaService.findCustomerById(id);
        request.setAttribute("customerInfo", customer);
        try {
            request.getRequestDispatcher("update_customer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customer_id = request.getParameter("id");
        String customer_type_id = request.getParameter("customer_type_id");
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        String customer_gender = request.getParameter("customer_gender");
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");

        String msg = furamaService.saveCustomer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender,
                customer_id_card, customer_phone, customer_email, customer_address);
        try {
            if (msg.equals("Please Input!!!") || msg.equals("Please Input Number!!!")) {
                request.setAttribute("message", msg);
                showFormUpdate(request, response);
            } else {
                loadListCustomer(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = furamaService.findAllCustomer();
        request.setAttribute("customerListFromServlet", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = furamaService.findAllEmployee();
        request.setAttribute("employeeListFromServlet", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create_customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customer_type_id = request.getParameter("customer_type_id");
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        String customer_gender = request.getParameter("customer_gender");
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");

        String msg = furamaService.saveCustomer("", customer_type_id, customer_name, customer_birthday, customer_gender,
                customer_id_card, customer_phone, customer_email, customer_address);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create_customer.jsp");
        request.setAttribute("message", msg);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormDeleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = furamaService.findCustomerById(id);

        request.setAttribute("customerInfo", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("delete_customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        furamaService.deleteCustomer(id);
        loadListCustomer(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String employee_name = request.getParameter("employee_name");
        String employee_birthday = request.getParameter("employee_birthday");
        String employee_id_card = request.getParameter("employee_id_card");
        String employee_salary = request.getParameter("employee_salary");
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        String position_id = request.getParameter("position_id");
        String education_degree_id = request.getParameter("education_degree_id");
        String division_id = request.getParameter("division_id");

        String msg = furamaService.saveEmployee("", employee_name, employee_birthday, employee_id_card, employee_salary,
                employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create_employee.jsp");
        request.setAttribute("message", msg);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create_employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdateEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = furamaService.findEmployeeById(id);
        request.setAttribute("employeeInfo", employee);
        try {
            request.getRequestDispatcher("update_employee.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        String employee_id = request.getParameter("id");
        String employee_name = request.getParameter("employee_name");
        String employee_birthday = request.getParameter("employee_birthday");
        String employee_id_card = request.getParameter("employee_id_card");
        String employee_salary = request.getParameter("employee_salary");
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        String position_id = request.getParameter("position_id");
        String education_degree_id = request.getParameter("education_degree_id");
        String division_id = request.getParameter("division_id");

        String msg = furamaService.saveEmployee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary,
                employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id);
        try {
            if (msg.equals("Please Input!!!") || msg.equals("Please Input Number!!!")) {
                request.setAttribute("message", msg);
                showFormUpdateEmployee(request, response);
            } else {
                loadListEmployee(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showFormDeleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = furamaService.findEmployeeById(id);

        request.setAttribute("employeeInfo", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("delete_employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        furamaService.deleteEmployee(id);
        loadListEmployee(request, response);
    }

    private void searchEmployeeById(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String msg;
        if (id.equals("")) {
            msg = "Please Input!!";
            request.setAttribute("message", msg);
        } else {
            Employee employee = furamaService.findEmployeeById(id);
            if (employee == null || employee.getEmployee_name() == null) {
                msg = "Not Found";
                request.setAttribute("message", msg);
            } else {
                request.setAttribute("employee", employee);
            }
        }
        try {
            request.getRequestDispatcher("search_employee_by_id.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchEmployeeByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String msg;
        if (name.equals("")) {
            msg = "Please Input!!!";
            request.setAttribute("message", msg);
        } else {
            List<Employee> employeeList = furamaService.findEmployeeByName(name);
            if (employeeList.isEmpty()) {
                msg = "Not Found";
                request.setAttribute("message", msg);
            } else {
                request.setAttribute("employeeListFromServlet", employeeList);
            }
        }
        try {
            request.getRequestDispatcher("search_employee_by_name.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreateService(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("create_service.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response){
        String service_name = request.getParameter("service_name");
        String service_area = request.getParameter("service_area");
        String service_cost = request.getParameter("service_cost");
        String service_max_people = request.getParameter("service_max_people");
        String rent_type_id = request.getParameter("rent_type_id");
        String service_type_id = request.getParameter("service_type_id");
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        String pool_area = request.getParameter("pool_area");
        String number_of_floors= request.getParameter("number_of_floors");

        String msg = furamaService.saveService(service_name,service_area,service_cost,service_max_people,rent_type_id,
                service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors);
        request.setAttribute("message",msg);
        try {
            request.getRequestDispatcher("create_service.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
