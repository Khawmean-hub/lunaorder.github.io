package com.kosign.luna.model.product;

import java.sql.Date;

public class ProductFilter {
    private String name = "";
    private Float startPrice = 0.0f;
    private Float endPrice = 100000.0f;
    private boolean isDiscount = false;
    private boolean isUnStock = false;
    private Date startDate = Date.valueOf("2015-01-01");
    private int categoryId = 0;
    private int brandId = 0;



    public ProductFilter() {
        
    }

    public ProductFilter(String name, Float startPrice, Float endPrice, boolean isDiscount, boolean isUnStock, Date startDate, int categoryId, int brandId) {
        this.name = name;
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        this.isDiscount = isDiscount;
        this.isUnStock = isUnStock;
        this.startDate = startDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getStartPrice() {
        return this.startPrice;
    }

    public void setStartPrice(Float startPrice) {
        this.startPrice = startPrice;
    }

    public Float getEndPrice() {
        return this.endPrice;
    }

    public void setEndPrice(Float endPrice) {
        this.endPrice = endPrice;
    }

    public boolean isIsDiscount() {
        return this.isDiscount;
    }

    public boolean getIsDiscount() {
        return this.isDiscount;
    }

    public void setIsDiscount(boolean isDiscount) {
        this.isDiscount = isDiscount;
    }

    public boolean isIsUnStock() {
        return this.isUnStock;
    }

    public boolean getIsUnStock() {
        return this.isUnStock;
    }

    public void setIsUnStock(boolean isUnStock) {
        this.isUnStock = isUnStock;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

}
