package com.web.shop.dto;

import com.web.shop.model.enums.UserRoles;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserProfileDTO {

    private Integer id;

    private String role = UserRoles.USER.getUserRole();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserProfile [id=" + id + ", type=" + role + "]";
    }

}
