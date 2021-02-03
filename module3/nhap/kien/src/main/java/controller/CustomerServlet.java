package controller;

import model.bean.Customer;
import model.service.customer.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    CustomerServiceImpl customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("actionUser");
        if(action == null){
            action = "";
        }

        switch (action) {
            case "addCustomer":
                addCustomer(request, response);
                break;
            case "editCustomer":
                updateCustomer(request,response);
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
            case "addCustomer":
                showAddCustomer(request,response);
                break;
            case "showListCustomer":
                showListCustomer(request,response);
                break;
            case "searchCustomer":
                searchCustomer(request,response);
                break;
            case "deleteCustomer":
                deleteCustomer(request,response);
                break;
            case "editCustomer":
                showUpdateCustomer(request,response);
                break;
        }
    }


    private void showHome(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    private void showAddCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Customer/addCustomer.jsp").forward(request,response);
    }

    private void addCustomer(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        int type = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String cmnd = request.getParameter("CMND");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id,type,name,dateOfBirth,gender,cmnd,phone,email,address);
        String msg = customerService.add(customer);

        request.setAttribute("msgDisplay",msg);
        if(msg.equals("OK")) {
            showHome(request, response);
        } else {
            showAddCustomer(request,response);
        }
    }


    private void showListCustomer(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomer", customerService.findAll());
        request.getRequestDispatcher("Customer/showListCustomer.jsp").forward(request,response);
    }

    private void searchCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("listCustomer", customerService.searchByName(name));
        request.getRequestDispatcher("Customer/searchCustomer.jsp").forward(request,response);
    }

    private void showUpdateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Customer customer = customerService.selectById(id);

        request.setAttribute("customer",customer);
        request.getRequestDispatcher("Customer/editCustomer.jsp").forward(request,response);
    }

    private void updateCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int type = Integer.parseInt(request.getParameter("type"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String id_card = request.getParameter("CMND");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id,type,name,dateOfBirth,gender,id_card,phone,email,address);
        customerService.update(customer);
        showListCustomer(request,response);
    }

    public void deleteCustomer(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String access = request.getParameter("value");
        String id = request.getParameter("id");

        customerService.delete(id,access);
        showListCustomer(request,response);
    }
}
