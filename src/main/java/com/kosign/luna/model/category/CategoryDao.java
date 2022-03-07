package com.kosign.luna.model.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Category")
@Table(name = "category")
public class CategoryDao {
    @Id
    @SequenceGenerator(name="category_id_seq",
                       sequenceName="category_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="category_id_seq")
    @Column(name = "id", updatable=false)
    private int id; 
    private String name;
    private int parentId;
    private String icon;
    


    public CategoryDao() {
    }

    public CategoryDao(int id, String name, int parentId, String icon) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
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

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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
            ", parentId='" + getParentId() + "'" +
            ", icon='" + getIcon() + "'" +
            "}";
    }

}
