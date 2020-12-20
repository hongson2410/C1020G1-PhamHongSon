package models;

public abstract class Services {
    String id;
    String nameService;
    float area;
    float price;
    int maxPeople;
    String rentTime;

    public Services() {
    }

    public Services(String id, String nameService, float area, float price, int maxPeople, String rentTime) {
        this.id = id;
        this.nameService = nameService;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentTime = rentTime;
    }

    public abstract String showInfo();

}
