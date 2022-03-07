package com.kosign.luna.model.weexpend;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "group_record")
public class GroupRecord {
    @Id
    @SequenceGenerator(name="group_record_id_seq",
            sequenceName="group_record_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="group_record_id_seq")
    @Column(name = "id", updatable=false)
    private int id;
    private String title;
    private String description;
    private Date date;
    private int byUserId;
    private int groupId;
    private double cash;
    private String reference;
    private String type; // in-out

    public GroupRecord() {
    }

    public GroupRecord(int id, String title, String description, Date date, int byUserId, int groupId, double cash, String reference, String type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.byUserId = byUserId;
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
