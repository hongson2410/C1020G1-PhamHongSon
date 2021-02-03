package controller;

import model.bean.CustomerUsingService;
import model.bean.House;
import model.bean.Room;
import model.bean.Villa;
import model.service.customer_using_service.ServiceCustomerUsing;
import model.service.house.HouseService;
import model.service.room.RoomService;
import model.service.villa.VillaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerUsingServlet",urlPatterns = "/customerUsing")
public class CustomerUsingServlet extends HttpServlet {

    ServiceCustomerUsing serviceCustomerUsing = new ServiceCustomerUsing();

    VillaService villaService = new VillaService();

    HouseService houseService = new HouseService();

    RoomService roomService = new RoomService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");

        if(action.equals("editService")){
            editService(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");

        if(action.equals("showCustomerUsing")){
            showCustomerUsing(request,response);
        } else if (action.equals("deleteService")){
            deleteService(request,response);
        } else if(action.equals("editService")){
            showEditService(request,response);
        }
    }

    private void showCustomerUsing(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomerUsing",serviceCustomerUsing.findAll());
        request.getRequestDispatcher("Customer/customerUsing.jsp").forward(request,response);
    }

    private void deleteService(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String access = request.getParameter("value");
        String id = request.getParameter("id");

        serviceCustomerUsing.delete(id,access);

        showCustomerUsing(request,response);
    }

    private void showEditService(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String idService = request.getParameter("id");
        int idType = Integer.parseInt(request.getParameter("idType"));

        if(idType == 1){
            Villa villa = villaService.selectById(idService);
            request.setAttribute("villa",villa);
            request.getRequestDispatcher("Villa/editVilla.jsp").forward(request,response);
        } else if(idType == 2){
            House house = houseService.selectById(idService);
            request.setAttribute("house",house);
            request.getRequestDispatcher("House/editHouse.jsp").forward(request,response);
        }else {
            Room room = roomService.selectById(idService);
            request.getRequestDispatcher("Room/editRoom.jsp").forward(request,response);
            request.setAttribute("room",room);
        }
    }

    private void editService(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer idType = Integer.parseInt(request.getParameter("idType"));
        String idService = request.getParameter("id");

        if(idType == 1){
            Villa villa;
            String nameVilla = request.getParameter("name");
            String standardRoom = request.getParameter("standard_room");
            Double area = Double.parseDouble(request.getParameter("area"));
            Double areaPool = Double.parseDouble(request.getParameter("area_pool"));
            Integer floor = Integer.parseInt(request.getParameter("floor"));
            Integer maxPeople = Integer.parseInt(request.getParameter("max_people"));
            Double cost = Double.parseDouble(request.getParameter("cost"));

            villa = new Villa(idService,idType,nameVilla,standardRoom,area,areaPool,floor,maxPeople,cost);
            villaService.update(villa);

        }
        else if (idType == 2){
            House house;
            String nameHouse = request.getParameter("name");
            String standardRoom = request.getParameter("standard_room");
            Double area = Double.parseDouble(request.getParameter("area"));
            Integer floor = Integer.parseInt(request.getParameter("floor"));
            Integer maxPeople = Integer.parseInt(request.getParameter("max_people"));
            Double cost = Double.parseDouble(request.getParameter("cost"));

            house = new House(idService,idType,nameHouse,standardRoom,area,floor,maxPeople,cost);

            houseService.update(house);
        }
        else {
            Room room;
            String nameRoom = request.getParameter("name");
            Double area = Double.parseDouble(request.getParameter("area"));
            Integer maxPeople = Integer.parseInt(request.getParameter("max_people"));
            Double cost = Double.parseDouble(request.getParameter("cost"));
            String freeService = request.getParameter("free_service");

            room = new Room(idService,idType,nameRoom,area,maxPeople,cost,freeService);

            roomService.update(room);
        }

        showCustomerUsing(request,response);
    }
}
