package models;

public abstract class Services {
    private String nameService;
    private int areaUsing;
    private double price;
    private int numberTenants;
    private String rentalType;

    public Services() {
    }

    public Services(String nameService, int areaUsing, double price, int numberTenants, String rentalType) {
        this.nameService = nameService;
        this.areaUsing = areaUsing;
        this.price = price;
        this.numberTenants = numberTenants;
        this.rentalType = rentalType;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getAreaUsing() {
        return areaUsing;
    }

    public void setAreaUsing(int areaUsing) {
        this.areaUsing = areaUsing;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberTenants() {
        return numberTenants;
    }

    public void setNumberTenants(int numberTenants) {
        this.numberTenants = numberTenants;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String showInfo() {
        return "Services{" +
                "nameService='" + nameService + '\'' +
                ", areaUsing=" + areaUsing +
                ", price=" + price +
                ", numberTenants=" + numberTenants +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
