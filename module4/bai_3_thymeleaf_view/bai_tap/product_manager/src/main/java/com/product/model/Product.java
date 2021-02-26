package com.product.model;

public class Product {
    private int id;
    private String name;
    private String manufacturer;
    private String productType;
    private int price;

    public Product() {
    }

    public Product(int id, String name, String manufacturer, String productType, int price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.productType =productType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
