package controller;

import model.bean.Employee;
import model.service.employee.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("actionUser");
        if(action == null){
            action = "";
        }

        switch (action) {
            case "addEmployee":
                addEmployee(request,response);
                break;
            case "editEmployee":
                updateEmployee(request,response);
                break;
            default:
                showHome(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("actionUser");
        if(action == null){
            action = "";
        }

        switch (action){
            case "addEmployee":
                showAddEmployee(request,response);
                break;
            case "showListEmployee":
                showListEmployee(request,response);
                break;
            case "searchEmployee":
                searchEmployee(request,response);
                break;
            case "editEmployee":
                showUpdateEmployee(request,response);
                break;
            case "deleteEmployee":
                deleteEmployee(request,response);
                break;
        }
    }

    private void showHome(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    private void showAddEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Employee/addEmployee.jsp").forward(request,response);
    }


    private void addEmployee(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int position = Integer.parseInt(request.getParameter("position"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String cmnd = request.getParameter("CMND");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Double salary = Double.parseDouble(request.getParameter("salary"));


        Employee employee = new Employee(id,name,dateOfBirth,gender,cmnd,salary,phone,email,address,position);
        employeeService.add(employee);
        showHome(request,response);
    }

    private void showListEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listEmployee", employeeService.findAll());
        request.getRequestDispatcher("Employee/showListEmployee.jsp").forward(request,response);
    }


    private void searchEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("listEmployee", employeeService.searchByName(name));
        request.getRequestDispatcher("Employee/searchEmployee.jsp").forward(request,response);
    }

    private void showUpdateEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Employee employee = employeeService.selectById(id);

        request.setAttribute("employee",employee);
        request.getRequestDispatcher("Employee/editEmployee.jsp").forward(request,response);
    }

    private void updateEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int position = Integer.parseInt(request.getParameter("position"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String id_card = request.getParameter("CMND");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Double salary = Double.parseDouble(request.getParameter("salary"));

        Employee employee = new Employee(id,name,dateOfBirth,gender,id_card,salary,phone,email,address,position);
        employeeService.update(employee);
        showListEmployee(request,response);
    }


    public void deleteEmployee(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String access = request.getParameter("value");
        String id = request.getParameter("id");

        employeeService.delete(id,access);
        showListEmployee(request,response);
    }



}
