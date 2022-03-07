package com.kosign.luna.model.user;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class UserDao implements UserDetails {
    /**
     *`
     */
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="webuser_id_seq",
                       sequenceName="webuser_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="webuser_id_seq")
    @Column(name = "id")
    private int id;
    private String username;
    @JsonIgnore
    private String password;
    private boolean active;
    private String role;

    public UserDao() {
    }

    public UserDao(int id, String name, String password, boolean active, String role) {
        this.id = id;
        this.username = name;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
        list.add(()->getRole());
        return list;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", active='" + isEnabled() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }

}
