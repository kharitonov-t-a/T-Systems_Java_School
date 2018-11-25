package com.web.shop.model.enums;

public enum DeliveryType {

    SELF("Self"),
    COURIER("Courier"),
    POSTAL("Postal");

    String delivery;

    DeliveryType(String delivery){
        this.delivery = delivery;
    }

    public String getDelivery() {
        return delivery;
    }
}
