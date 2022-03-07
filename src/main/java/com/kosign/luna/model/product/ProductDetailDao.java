package com.kosign.luna.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products_detail")
public class ProductDetailDao {
    @Id
    @Column(name = "id")
    private int id;
    private String cpu;
    private String ram;
    private String storage;
    private String screen;
    private String vga1;
    private String vga2;
    private String feature;
    private String color;
    private String windowLic;
    private String battery;
    private String weight;
    private String free;


    public ProductDetailDao() {
    }

    public ProductDetailDao(int id, String cpu, String ram, String storage, String screen, String vga1, String vga2, String feature, String color, String windowLic, String battery, String weight, String free) {
        this.id = id;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
        this.vga1 = vga1;
        this.vga2 = vga2;
        this.feature = feature;
        this.color = color;
        this.windowLic = windowLic;
        this.battery = battery;
        this.weight = weight;
        this.free = free;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpu() {
        return this.cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return this.ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return this.storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getScreen() {
        return this.screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getVga1() {
        return this.vga1;
    }

    public void setVga1(String vga1) {
        this.vga1 = vga1;
    }

    public String getVga2() {
        return this.vga2;
    }

    public void setVga2(String vga2) {
        this.vga2 = vga2;
    }

    public String getFeature() {
        return this.feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWindowLic() {
        return this.windowLic;
    }

    public void setWindowLic(String windowLic) {
        this.windowLic = windowLic;
    }

    public String getBattery() {
        return this.battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getFree() {
        return this.free;
    }

    public void setFree(String free) {
        this.free = free;
    }


    
}
