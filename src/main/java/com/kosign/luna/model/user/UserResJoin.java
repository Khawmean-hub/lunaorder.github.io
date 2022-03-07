package com.kosign.luna.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;


@Entity
@Table(name = "users")
@SecondaryTable(name = "customers", pkJoinColumns = @PrimaryKeyJoinColumn(name="userId"))
public class UserResJoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  table = "users")
    int id;

    @Column(name = "id",  table = "customers")
    int customerId;

    @Column(name = "name", table = "customers")
    String name;

    @Column(name = "username")
    String username;

    @Column(name = "email", table = "customers")
    String email;

    @Column(name = "gender", table = "customers")
    String gender;

    @Column(name = "phone", table = "customers")
    String phone;

    @Column(name = "profile", table = "customers")
    String profile;

    @Column(name = "role")
    String role;

    @Column(name = "active")
    String active;



    public UserResJoin() {
    }

    public UserResJoin(int id, int customerId, String name, String username, String email, String gender, String phone, String profile, String role, String active) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.profile = profile;
        this.role = role;
        this.active = active;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public UserResJoin id(int id) {
        setId(id);
        return this;
    }

    public UserResJoin customerId(int customerId) {
        setCustomerId(customerId);
        return this;
    }

    public UserResJoin name(String name) {
        setName(name);
        return this;
    }

    public UserResJoin username(String username) {
        setUsername(username);
        return this;
    }

    public UserResJoin email(String email) {
        setEmail(email);
        return this;
    }

    public UserResJoin gender(String gender) {
        setGender(gender);
        return this;
    }

    public UserResJoin phone(String phone) {
        setPhone(phone);
        return this;
    }

    public UserResJoin profile(String profile) {
        setProfile(profile);
        return this;
    }

    public UserResJoin role(String role) {
        setRole(role);
        return this;
    }

    public UserResJoin active(String active) {
        setActive(active);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", customerId='" + getCustomerId() + "'" +
            ", name='" + getName() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", gender='" + getGender() + "'" +
            ", phone='" + getPhone() + "'" +
            ", profile='" + getProfile() + "'" +
            ", role='" + getRole() + "'" +
            ", active='" + getActive() + "'" +
            "}";
    }

}
