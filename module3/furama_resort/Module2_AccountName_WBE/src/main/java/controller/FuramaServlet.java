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
            case "delete":
                deleteCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
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
            default:
                loadListCustomer(request, response);
                break;
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
            if (customer == null) {
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
            if (msg.equals("Please Input!!!")) {
//                Customer customer = new Customer(Integer.parseInt(customer_id),Integer.parseInt(customer_type_id),customer_name,
//                        customer_birthday,Integer.parseInt(customer_gender),customer_id_card,customer_phone,customer_email,
//                        customer_address);
//                request.setAttribute("customerInfo", customer);
                request.setAttribute("message", msg);
                showFormUpdate(request, response);
//                request.getRequestDispatcher("update_customer.jsp").forward(request, response);
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

        furamaService.saveCustomer("",customer_type_id,customer_name,customer_birthday,customer_gender,
                customer_id_card,customer_phone,customer_email,customer_address);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create_customer.jsp");
        request.setAttribute("message", "Add more congratulations!!");
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
}
