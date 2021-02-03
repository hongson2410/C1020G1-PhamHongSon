package controller;

import bean.Employee;
import service.EmployeeService;
import service.function.Input;
import service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"", "/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    String actionUser;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        actionUser = request.getParameter("actionUser");
        switch (actionUser) {
            case "create":
                createEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            default:
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "update":
                showUpdateForm(request, response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "search":
                showViewForm(request, response);
                break;
            default:
                loadList(request, response);
        }
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employeeListFromServlet", employeeService.findAll());
        request.getRequestDispatcher("Employee/listEmployee.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Employee/createEmployee.jsp").forward(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String messenger;

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
        String user_username = request.getParameter("user_username");

        Employee employee = new Employee(employee_name, employee_birthday, employee_id_card,
                employee_salary, employee_phone, employee_email, employee_address,
                position_id, education_degree_id, division_id, user_username);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Employee/createEmployee.jsp");

        messenger = employeeService.save(employee);
        request.setAttribute("employeeInfo", employee);
        request.setAttribute("messenger", messenger);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);

        request.setAttribute("employeeInfo", employee);
        request.getRequestDispatcher("Employee/updateEmployee.jsp").forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        String messenger;
        String employee_id = request.getParameter("employee_id");
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
        String user_username = request.getParameter("user_username");

        Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card,
                employee_salary, employee_phone, employee_email, employee_address,
                position_id, education_degree_id, division_id, user_username);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Employee/updateEmployee.jsp");

        messenger = employeeService.save(employee);
        request.setAttribute("employeeInfo", employee);
        request.setAttribute("messenger", messenger);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        String messenger = "NG";
        request.setAttribute("messenger", messenger);
        request.setAttribute("employeeInfo", employee);
        request.getRequestDispatcher("Employee/deleteEmployee.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteById(id);
        String messenger = "OK";
        request.setAttribute("messenger", messenger);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Employee/deleteEmployee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Employee> listView = employeeService.findByName(name);
        RequestDispatcher dispatcher;
        String messenger;
        if (listView.isEmpty() || name.equals("")) {
            messenger = "NG";
            request.setAttribute("messenger", messenger);
            dispatcher = request.getRequestDispatcher("Employee/viewEmployee.jsp");
        } else {
            messenger = "OK";
            request.setAttribute("messenger", messenger);
            request.setAttribute("employeeListFromServlet", listView);
            dispatcher = request.getRequestDispatcher("Employee/viewEmployee.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

