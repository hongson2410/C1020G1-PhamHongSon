package model.bean;

public class House {
    String idService;
    int idHouse;
    String nameHouse;
    String standard_room;
    double area;
    int floor;
    int max_people;
    double cost;

    public House(){

    }

    public House(int idHouse, String nameHouse, String standard_room, double area, int floor, int max_people, double cost) {
        this.idHouse = idHouse;
        this.nameHouse = nameHouse;
        this.standard_room = standard_room;
        this.area = area;
        this.floor = floor;
        this.max_people = max_people;
        this.cost = cost;
    }

    public String getIdService() {
        return idService;
    }

    public House(String idService, int idHouse, String nameHouse, String standard_room, double area, int floor, int max_people, double cost) {
        this.idService = idService;
        this.idHouse = idHouse;
        this.nameHouse = nameHouse;
        this.standard_room = standard_room;
        this.area = area;
        this.floor = floor;
        this.max_people = max_people;
        this.cost = cost;
    }

    public int getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(int idHouse) {
        this.idHouse = idHouse;
    }

    public String getNameHouse() {
        return nameHouse;
    }

    public void setNameHouse(String nameHouse) {
        this.nameHouse = nameHouse;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
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
}
