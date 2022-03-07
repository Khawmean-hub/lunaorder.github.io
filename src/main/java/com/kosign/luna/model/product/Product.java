package com.kosign.luna.model.product;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kosign.luna.model.brand.Brand;
import com.kosign.luna.model.category.CategoryDao;



@Entity(name = "Products")
@Table(name = "products")
public class Product{

    @Id
    @SequenceGenerator(name="product_id_seq",
                       sequenceName="product_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="product_id_seq")
    @Column(name = "id", updatable=false)
    private int id;
    private String name;
    private String description;
    private float price;
    private String profile;
    private int discount;
    private int stock;
    private Date registerDate;
    @JoinColumn(name = "categoryId", referencedColumnName = "Id")
    @ManyToOne(targetEntity = CategoryDao.class)
    private CategoryDao category;
    @JoinColumn(name = "brandId", referencedColumnName = "Id")
    @ManyToOne(targetEntity = Brand.class)
    private Brand brand;
    

    public Product() {
    }

    public Product(int id, String name, String description, float price, String profile, int discount, int stock, Date registerDate, CategoryDao category, Brand brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.profile = profile;
        this.discount = discount;
        this.stock = stock;
        this.registerDate = registerDate;
        this.category = category;
        this.brand = brand;
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

    public CategoryDao getCategory() {
        return this.category;
    }

    public void setCategory(CategoryDao category) {
        this.category = category;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
