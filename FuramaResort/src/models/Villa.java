package models;

public class Villa extends Services{
    private String roomStandard;
    private String convenient;
    private float areaPool;
    private int floor;

    public Villa() {
    }

    public Villa(String roomStandard, String convenient, float areaPool, int floor) {
        this.roomStandard = roomStandard;
        this.convenient = convenient;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public Villa(String id, String nameService, float area, float price, int maxPeople, String rentTime, String roomStandard, String convenient, float areaPool, int floor) {
        super(id, nameService, area, price, maxPeople, rentTime);
        this.roomStandard = roomStandard;
        this.convenient = convenient;
        this.areaPool = areaPool;
        this.floor = floor;
    }


    @Override
    public String showInfo() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", convenient='" + convenient + '\'' +
                ", areaPool=" + areaPool +
                ", floor=" + floor +
                '}';
    }
}
