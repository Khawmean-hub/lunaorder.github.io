package com.kosign.luna.model.user;

/**
 * UserRes
 */
public class UserRes {
    private int id;
    private String username;
    private boolean active;
    private String role;


    public UserRes() {
    }

    public UserRes(int id, String username, boolean active, String role) {
        this.id = id;
        this.username = username;
        this.active = active;
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }    
}