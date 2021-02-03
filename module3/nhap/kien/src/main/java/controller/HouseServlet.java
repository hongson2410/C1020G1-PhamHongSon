package controller;

import model.bean.House;
import model.bean.Villa;
import model.service.house.HouseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HouseServlet",urlPatterns = "/house")
public class HouseServlet extends HttpServlet {

    HouseService houseService = new HouseService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("actionUser");

        if(action == null){
            action = "";
        }

        switch (action){
            case "addHouse":
                createHouse(request,response);
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
            case "addHouse":
                showCreateHouse(request,response);
                break;
            case "showHouse":
                showHouse(request,response);
                break;
        }
    }

    private void showCreateHouse(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("House/house.jsp").forward(request,response);
    }

    private void createHouse(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String idService = request.getParameter("service_id");
        int idHouse = Integer.parseInt(request.getParameter("service_type_id"));
        String name = request.getParameter("name");
        String standardRoom = request.getParameter("standard_room");
        double area = Double.parseDouble(request.getParameter("area"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        int maxPeople = Integer.parseInt(request.getParameter("max_people"));
        double cost = Double.parseDouble(request.getParameter("cost"));

        House house = new House(idService,idHouse,name,standardRoom,area,floor,maxPeople,cost);
        String msg = houseService.add(house);
        request.setAttribute("msgDisplay",msg);
        if(msg.equals("OK")){
            showHouse(request,response);
        }else {
            showCreateHouse(request,response);
        }
    }

    private void showHouse(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        List<House> houseList = houseService.findAll();
        request.setAttribute("listHouse",houseList);
        request.getRequestDispatcher("House/showHouse.jsp").forward(request,response);
    }
}
