package com.kosign.luna.model.weexpend;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "group_budget")
public class GroupBudget {
    @Id
    @SequenceGenerator(name="group_budget_id_seq",
            sequenceName="group_budget_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="group_budget_id_seq")
    @Column(name = "id", updatable=false)
    private int id;
    private String name;
    private String description;
    private String icon;
    private Date creatDate;
    private double limitExpend;
    private boolean active;

    public GroupBudget() {
    }

    public GroupBudget(int id, String name, String description, String icon, Date creatDate, double limitExpend, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.creatDate = creatDate;
        this.limitExpend = limitExpend;
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

    public double getLimit() {
        return limitExpend;
    }

    public void setLimit(double limitExpend) {
        this.limitExpend = limitExpend;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
