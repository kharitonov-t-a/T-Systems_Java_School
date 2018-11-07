package com.web.shop.model.Users;

import com.web.shop.model.enums.UserRolesEnum;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "Role", length = 15, unique = true, nullable = false)
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
        return "UserProfile{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
