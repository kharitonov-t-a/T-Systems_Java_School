package com.web.shop.model.enums;

public enum UserRoles {

    USER("USER"),
    MANAGER("MANAGER"),
    ADMIN("ADMIN");

    String userRole;

    UserRoles(String userType){
        this.userRole = userType;
    }

    public String getUserRole(){
        return userRole;
    }

}
