package com.kosign.luna.model.product;

import java.sql.Date;

public class ProductReq {

    private int id;
    private String name;
    private String description;
    private float price;
    private String profile;
    private int discount;
    private int categoryId;
    private int brandId;
    private int stock;
    private Date registerDate;


    public ProductReq() {
    }

    public ProductReq(int id, String name, String description, float price, String profile, int discount, int categoryId, int brandId, int stock, Date registerDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.profile = profile;
        this.discount = discount;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.stock = stock;
        this.registerDate = registerDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return this.brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    
}
