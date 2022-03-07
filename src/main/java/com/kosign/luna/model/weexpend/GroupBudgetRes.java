package com.kosign.luna.model.weexpend;

import java.sql.Date;
import java.util.List;

public class GroupBudgetRes {
    private int id;
    private String name;
    private String description;
    private String icon;
    private Date creatDate;
    private List<UserInfo> member;
    private double limitExpend;
    private double totalIncome;
    private double totalExpend;
    private boolean active;

    public GroupBudgetRes() {
    }

    public GroupBudgetRes(int id, String name, String description, String icon, Date creatDate, List<UserInfo> member, double limitExpend, double totalIncome, double totalExpend, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.creatDate = creatDate;
        this.member = member;
        this.limitExpend = limitExpend;
        this.totalIncome = totalIncome;
        this.totalExpend = totalExpend;
        this.active = active;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public List<UserInfo> getMember() {
        return member;
    }

    public void setMember(List<UserInfo> member) {
        this.member = member;
    }

    public double getLimit() {
        return limitExpend;
    }

    public void setLimit(double limitExpend) {
        this.limitExpend = limitExpend;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpend() {
        return totalExpend;
    }

    public void setTotalExpend(double totalExpend) {
        this.totalExpend = totalExpend;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
