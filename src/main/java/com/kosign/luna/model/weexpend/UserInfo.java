package com.kosign.luna.model.weexpend;

public class UserInfo {
    private int id;
    private String name;
    private String profile;

    public UserInfo() {
    }

    public UserInfo(int id, String name, String profile) {
        this.id = id;
        this.name = name;
        this.profile = profile;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
