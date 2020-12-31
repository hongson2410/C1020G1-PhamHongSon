package models.service;

public class Villa extends Services {
    private String roomStandard;
    private String roomFurniture;
    private double poolArea;
    private int floors;

    public Villa() {
    }

    public Villa(String idService, String nameService, double areaUsing, double price, int numberTenants, String rentalType, String roomStandard, String roomFurniture, double poolArea, int floors) {
        super(idService, nameService, areaUsing, price, numberTenants, rentalType);
        this.roomStandard = roomStandard;
        this.roomFurniture = roomFurniture;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getRoomFurniture() {
        return roomFurniture;
    }

    public void setRoomFurniture(String roomFurniture) {
        this.roomFurniture = roomFurniture;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }


    @Override
    public String showInfo() {
        return "Villa{" + super.showInfo() +
                "roomStandard=" + roomStandard +
                ", roomFurniture='" + roomFurniture + '\'' +
                ", poolArea=" + poolArea +
                ", floors=" + floors +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() + ',' +
                roomStandard + ','
                + roomFurniture + ','
                + poolArea + ','
                + floors;
    }
}
