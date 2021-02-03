package model.bean;

public class Villa {
    String idService;
    int idVilla;
    String nameVilla;
    String standard_room;
    double area;
    double pool_area;
    int floor;
    int max_people;
    double cost;

    public String getIdService() {
        return idService;
    }

    public Villa(){

    }

    public Villa(String idService, int idVilla, String nameVilla, String standard_room,
                 double area, double pool_area, int floor, int max_people, double cost) {
        this.idService = idService;
        this.idVilla = idVilla;
        this.nameVilla = nameVilla;
        this.standard_room = standard_room;
        this.area = area;
        this.pool_area = pool_area;
        this.floor = floor;
        this.max_people = max_people;
        this.cost = cost;
    }

    public Villa(int idVilla, String nameVilla, String standard_room,
                 double area, double pool_area, int floor, int max_people, double cost) {
        this.idVilla = idVilla;
        this.nameVilla = nameVilla;
        this.standard_room = standard_room;
        this.area = area;
        this.pool_area = pool_area;
        this.floor = floor;
        this.max_people = max_people;
        this.cost = cost;
    }

    public int getIdVilla() {
        return idVilla;
    }

    public void setIdVilla(int idVilla) {
        this.idVilla = idVilla;
    }

    public String getNameVilla() {
        return nameVilla;
    }

    public void setNameVilla(String nameVilla) {
        this.nameVilla = nameVilla;
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

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
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
