package com.web.shop.model.enums;

public enum DeliveryEnum {

    SELF("Self"),
    COURIER("Courier"),
    POSTAL("Postal");

    String delivery;

    DeliveryEnum(String delivery){
        this.delivery = delivery;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
}
