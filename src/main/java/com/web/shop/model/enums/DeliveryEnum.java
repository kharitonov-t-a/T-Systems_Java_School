package com.web.shop.model.enums;

public enum DeliveryEnum {

    SELF("SELF"),
    COURIER("COURIER"),
    POSTAL("POSTAL");

    String delivery;

    DeliveryEnum(String delivery){
        this.delivery = delivery;
    }

}
