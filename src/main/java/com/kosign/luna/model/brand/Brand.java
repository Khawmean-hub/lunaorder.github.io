package com.kosign.luna.model.brand;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Brands")
@Table(name = "brands")
public class Brand {

    @Id
    @SequenceGenerator(name="brands_id_seq",
                       sequenceName="brands_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="brands_id_seq")
    @Column(name = "id", updatable=false)
    private int id; 
    private String name;
    private String icon;


    public Brand() {
    }

    public Brand(int id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
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

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", icon='" + getIcon() + "'" +
            "}";
    }

}
