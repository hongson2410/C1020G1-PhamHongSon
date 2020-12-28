package models;

public class Room extends Services {
    String freeService;

    public Room() {
    }

    public Room(String nameService, int areaUsing, double price, int numberTenants, String rentalType, String freeService) {
        super(nameService, areaUsing, price, numberTenants, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String showInfo() {
        return "Room{" + super.showInfo() +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
