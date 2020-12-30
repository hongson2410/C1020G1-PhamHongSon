package models;

public abstract class Services {
    private String idService;
    private String nameService;
    private double areaUsing;
    private double price;
    private int numberTenants;
    private String rentalType;

    public Services() {
    }

    public Services(String idService, String nameService, double areaUsing, double price, int numberTenants, String rentalType) {
        this.idService = idService;
        this.nameService = nameService;
        this.areaUsing = areaUsing;
        this.price = price;
        this.numberTenants = numberTenants;
        this.rentalType = rentalType;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUsing() {
        return areaUsing;
    }

    public void setAreaUsing(double areaUsing) {
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
                "idService='" + idService + '\'' +
                ", nameService='" + nameService + '\'' +
                ", areaUsing=" + areaUsing +
                ", price=" + price +
                ", numberTenants=" + numberTenants +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return idService + ','
                + nameService + ','
                + areaUsing + ','
                + price + ','
                + numberTenants + ','
                + rentalType;
    }
}
