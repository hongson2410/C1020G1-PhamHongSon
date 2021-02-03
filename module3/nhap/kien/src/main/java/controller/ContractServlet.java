package controller;

import model.bean.Contract;
import model.service.contract.ContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContractServlet",urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {

    ContractService contractService = new ContractService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("actionUser");
        if(action == null){
            action = "";
        }

        if(action.equals("addContract")){
            addContract(request,response);
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
            case "addContract":
                showAddContract(request,response);
                break;
            case "showListContract":
                showListContract(request,response);
                break;
        }
    }

    private void showHome(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    private void addContract(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        String dateStart = request.getParameter("start_date");
        String dateEnd = request.getParameter("end_date");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double total = Double.parseDouble(request.getParameter("total"));
        String idEmployee = request.getParameter("id_employee");
        String idCustomer = request.getParameter("id_customer");
        String idService = request.getParameter("id_service");

        Contract contract = new Contract(dateStart,dateEnd,deposit,total,idEmployee,idCustomer,idService);

        contractService.add(contract);
        showHome(request,response);
    }

    private void showAddContract(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Contract/contract.jsp").forward(request,response);
    }

    private void showListContract(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listContract",contractService.findAll());
        request.getRequestDispatcher("Contract/show_contract.jsp").forward(request,response);
    }
}
