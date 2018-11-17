package com.web.shop.model.user;

import com.web.shop.model.enums.UserRoles;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserProfile")
//@Setter
public class UserProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "role", length = 15, unique = true, nullable = false)
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
//        return "UserProfile{" +
//                "id=" + id +
//                ", role='" + role + '\'' +
//                '}';
//    }
}
