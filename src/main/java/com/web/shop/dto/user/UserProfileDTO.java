package com.web.shop.dto.user;

import com.web.shop.model.enums.UserRoles;

import java.io.Serializable;

public class UserProfileDTO implements Serializable {

    private Integer id;

    private String role = UserRoles.USER.toString();

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

//    @Override
//    public String toString() {
//        return "UserProfileDTO{" +
//                "id=" + id +
//                ", role='" + role + '\'' +
//                '}';
//    }
}
