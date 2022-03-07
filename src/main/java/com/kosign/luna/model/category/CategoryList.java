package com.kosign.luna.model.category;

import java.util.List;

public class CategoryList {
    private int id; 
    private String name;
    private String icon;
    private List<CategoryDao> subCategory;


    public CategoryList() {
    }

    public CategoryList(int id, String name, String icon, List<CategoryDao> subCategory) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.subCategory = subCategory;
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

    public List<CategoryDao> getSubCategory() {
        return this.subCategory;
    }

    public void setSubCategory(List<CategoryDao> subCategory) {
        this.subCategory = subCategory;
    }

    public CategoryList id(int id) {
        setId(id);
        return this;
    }

    public CategoryList name(String name) {
        setName(name);
        return this;
    }

    public CategoryList icon(String icon) {
        setIcon(icon);
        return this;
    }

    public CategoryList subCategory(List<CategoryDao> subCategory) {
        setSubCategory(subCategory);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", icon='" + getIcon() + "'" +
            ", subCategory='" + getSubCategory() + "'" +
            "}";
    }

}