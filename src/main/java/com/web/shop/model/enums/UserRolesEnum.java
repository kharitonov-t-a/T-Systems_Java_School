package com.web.shop.model.enums;

public enum UserRolesEnum {

    USER("USER"),
    MANAGER("MANAGER"),
    ADMIN("ADMIN");

    String userRole;

    UserRolesEnum(String userType){
        this.userRole = userType;
    }

}
