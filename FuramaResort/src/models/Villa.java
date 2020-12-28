package models;

public class Villa extends Services {
    private String roomStandard;
    private String roomFurniture;
    private int poolArea;
    private int floors;

    public Villa() {
    }

    public Villa(String nameService, int areaUsing, double price, int numberTenants, String rentalType, String roomStandard, String roomFurniture, int poolArea, int floors) {
        super(nameService, areaUsing, price, numberTenants, rentalType);
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

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
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


}
