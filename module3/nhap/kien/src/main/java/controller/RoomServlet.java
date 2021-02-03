package controller;

import model.bean.House;
import model.bean.Room;
import model.service.room.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoomServlet",urlPatterns = "/room")
public class RoomServlet extends HttpServlet {

    RoomService roomService = new RoomService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("actionUser");

        if(action == null){
            action = "";
        }

        switch (action){
            case "addRoom":
                createRoom(request,response);
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
            case "addRoom":
                showCreateRoom(request,response);
                break;
            case "showRoom":
                showRoom(request,response);
                break;
        }
    }


    private void showCreateRoom(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("Room/room.jsp").forward(request,response);
    }

    private void createRoom(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String idService = request.getParameter("service_id");
        int idRoom = Integer.parseInt(request.getParameter("service_type_id"));
        String name = request.getParameter("name");
        double area = Double.parseDouble(request.getParameter("area"));
        int maxPeople = Integer.parseInt(request.getParameter("max_people"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        String freeService = request.getParameter("free_service");

        Room room = new Room(idService,idRoom,name,area,maxPeople,cost,freeService);
        String msg = roomService.add(room);
        request.setAttribute("msgDisplay",msg);
        if(msg.equals("OK")){
            showRoom(request,response);
        }else {
            showCreateRoom(request,response);
        }
    }

    private void showRoom(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        List<Room> roomList = roomService.findAll();
        request.setAttribute("listRoom",roomList);
        request.getRequestDispatcher("Room/showRoom.jsp").forward(request,response);
    }
}
