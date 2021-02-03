package model.bean;

public class Room {
    int idRoom;
    String idService;
    String nameRoom;
    double area;
    int max_people;
    double cost;
    String freeService;

    public Room(){

    }

    public Room(int idRoom, String nameRoom, double area, int max_people, double cost, String freeService) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.area = area;
        this.max_people = max_people;
        this.cost = cost;
        this.freeService = freeService;
    }

    public String getIdService() {
        return idService;
    }

    public Room(String idService,int idRoom, String nameRoom, double area, int max_people, double cost, String freeService) {
        this.idRoom = idRoom;
        this.idService = idService;
        this.nameRoom = nameRoom;
        this.area = area;
        this.max_people = max_people;
        this.cost = cost;
        this.freeService = freeService;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
