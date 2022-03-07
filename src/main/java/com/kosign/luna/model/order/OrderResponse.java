package com.kosign.luna.model.order;

public class OrderResponse {

    private int id;
    private String customrName;
    private String productName;
    private float price;
    private int discount;
    private float rate;
    private String date;

    public OrderResponse() {
    }

    public OrderResponse(OrderRes orderRes) {
        this.id = orderRes.id();
        this.customrName = orderRes.customrName();
        this.productName = orderRes.productName();
        this.price= orderRes.price();
        this.discount= orderRes.discount();
        this.rate = orderRes.rate();
        this.date = orderRes.date();
    }

    public OrderResponse(int id, String customrName, String productName, float price, int discount, float rate, String date) {
        this.id = id;
        this.customrName = customrName;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.rate = rate;
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomrName() {
        return this.customrName;
    }

    public void setCustomrName(String customrName) {
        this.customrName = customrName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public float getRate() {
        return this.rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
  
}
