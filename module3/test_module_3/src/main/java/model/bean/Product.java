package model.bean;

public class Product {
    private Integer product_id;
    private String product_name;
    private int price;
    private int discount;
    private int stock;

    public Product() {
    }

    public Product(String product_name, int price, int discount, int stock) {
        this.product_name = product_name;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public Product(Integer product_id, String product_name, int price, int discount, int stock) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
