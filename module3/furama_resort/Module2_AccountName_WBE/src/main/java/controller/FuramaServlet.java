package controller;

import model.bean.Customer;
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
            default:
                loadListCustomer(request,response);
                break;
        }
    }

    private  void loadListCustomer(HttpServletRequest request, HttpServletResponse response){
        List<Customer> customerList = furamaService.findAllCustomer();
        request.setAttribute("customerListFromServlet", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_customer.jsp");
        try {
            dispatcher.forward(request,response);
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
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        int customer_gender = Integer.parseInt(request.getParameter("customer_gender"));
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");

        Customer customer = new Customer(customer_type_id,customer_name,customer_birthday,customer_gender,
                customer_id_card,customer_phone,customer_email,customer_address);
        furamaService.saveCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create_customer.jsp");
        request.setAttribute("message","Add more congratulations!!");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
