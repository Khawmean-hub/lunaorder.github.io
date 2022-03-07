package com.kosign.luna.model.order;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name="order_id_seq",
                       sequenceName="order_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="order_id_seq")
    @Column(name = "id", updatable=false)
    private int id;
    private int customer;
    private int product;
    private int discount;
    private float rate;
    private String date;
    
    public Order() {
    }

    public Order(int id, int customer, int product, int discount, float rate, String date) {
        this.id = id;
        this.customer = customer;
        this.product = product;
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

    public int getcustomer() {
        return this.customer;
    }

    public void setcustomer(int customer) {
        this.customer = customer;
    }

    public int getproduct() {
        return this.product;
    }

    public void setproduct(int product) {
        this.product = product;
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
