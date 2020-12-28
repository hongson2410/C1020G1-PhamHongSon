package models;

public class House extends Services {
    private String roomStandard;
    private String roomFurniture;
    private int floors;

    public House() {
    }

    public House(String nameService, int areaUsing, double price, int numberTenants, String rentalType, String roomStandard, String roomFurniture, int floors) {
        super(nameService, areaUsing, price, numberTenants, rentalType);
        this.roomStandard = roomStandard;
        this.roomFurniture = roomFurniture;
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

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String showInfo() {
        return "House{" + super.showInfo() +
                "roomStandard='" + roomStandard + '\'' +
                ", roomFurniture='" + roomFurniture + '\'' +
                ", floors=" + floors +
                '}';
    }
}
