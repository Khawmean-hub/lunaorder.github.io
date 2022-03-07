package com.kosign.luna.model.weexpend;

import javax.persistence.Transient;
import java.util.Date;

public class GroupRecordRes {
    private int id;
    private String title;
    private String description;
    private Date date;
    private int byUserId;
    private String userProfile;
    private int groupId;
    private double cash;
    private String reference;
    private String type; // in-out

    public GroupRecordRes() {
    }

    public GroupRecordRes(int id, String title, String description, Date date, int byUserId, String userProfile, int groupId, double cash, String reference, String type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.byUserId = byUserId;
        this.userProfile = userProfile;
        this.groupId = groupId;
        this.cash = cash;
        this.reference = reference;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getByUserId() {
        return byUserId;
    }

    public void setByUserId(int byUserId) {
        this.byUserId = byUserId;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
