package com.kosign.luna.model.user;

public class UserDto {

    private String username;
    private String password;
    private boolean active;
    private String role;

    public UserDto() {
    }


    public UserDto(String username, String password, boolean active, String role) {
       
        this.username = username;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return active;
    }
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
