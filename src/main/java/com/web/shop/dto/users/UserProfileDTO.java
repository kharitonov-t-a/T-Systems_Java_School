package com.web.shop.dto.users;

import com.web.shop.model.enums.UserRolesEnum;

import java.io.Serializable;

public class UserProfileDTO implements Serializable {

    private Integer id;

    private String role = UserRolesEnum.USER.toString();

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
