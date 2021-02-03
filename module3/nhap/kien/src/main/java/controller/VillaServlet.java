package controller;

import model.bean.Villa;
import model.service.villa.VillaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VillaServlet",urlPatterns = "/villa")
public class VillaServlet extends HttpServlet {

    VillaService villaService = new VillaService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("actionUser");

        if(action == null){
            action = "";
        }

        switch (action){
            case "addVilla":
                createVilla(request,response);
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
            case "addVilla":
                showCreateVilla(request,response);
                break;
            case "showVilla":
                showVilla(request,response);
                break;
        }
    }

    private void showCreateVilla(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("Villa/villa.jsp").forward(request,response);
    }

    private void createVilla(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String idService = request.getParameter("service_id");
        int idVilla = Integer.parseInt(request.getParameter("service_type_id"));
        String name = request.getParameter("name");
        String standardRoom = request.getParameter("standard_room");
        double area = Double.parseDouble(request.getParameter("area"));
        double areaPool = Double.parseDouble(request.getParameter("area_pool"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        int maxPeople = Integer.parseInt(request.getParameter("max_people"));
        double cost = Double.parseDouble(request.getParameter("cost"));

        Villa villa = new Villa(idService,idVilla,name,standardRoom,area,areaPool,floor,maxPeople,cost);
        String msg = villaService.add(villa);
        request.setAttribute("msgDisplay",msg);
        if(msg.equals("OK")){
            showVilla(request,response);
        }else {
            showCreateVilla(request,response);
        }
    }

    private void showVilla(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        List<Villa> villaList = villaService.findAll();
        request.setAttribute("listVilla",villaList);
        request.getRequestDispatcher("Villa/showVilla.jsp").forward(request,response);
    }
}
