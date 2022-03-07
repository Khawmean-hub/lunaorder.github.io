package com.kosign.luna.model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @SequenceGenerator(name="customer_id_seq",
                       sequenceName="customer_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="customer_id_seq")
    @Column(name = "id", updatable=false)
    private int id;
    private int userId;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String profile;
    private boolean enable;
    

    public Customer() {
    }

    public Customer(int id, int userId, String name, String gender, String phone, String email, String profile, boolean enable) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.profile = profile;
        this.enable = enable;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean getEnable() {
        return this.enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
