package controller;

import model.bean.AttachService;
import model.service.attach_service.AttachServiceOfService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AttachServiceServlet",urlPatterns = "/attach")
public class AttachServiceServlet extends HttpServlet {

    AttachServiceOfService attachServiceOfService = new AttachServiceOfService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("actionUser");
        if(action == null){
            action = "";
        }

        if(action.equals("attachService")){
            addAttachService(request,response);
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

        if(action.equals("attachService")){
            showAddAttach(request,response);
        }
    }

    private void showHome(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    private void showAddAttach(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("AttachService/attach_service.jsp").forward(request,response);
    }

    private void addAttachService(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        double cost = Double.parseDouble(request.getParameter("cost"));
        int unit = Integer.parseInt(request.getParameter("unit"));
        int idContract = Integer.parseInt(request.getParameter("idContract"));

        AttachService attachService = new AttachService(id,type,cost,unit,idContract);

        attachServiceOfService.add(attachService);
        showHome(request,response);
    }
}
