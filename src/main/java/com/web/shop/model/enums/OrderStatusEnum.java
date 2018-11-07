package com.web.shop.model.enums;

public enum OrderStatusEnum {

    AWAITING_PAID("1"),
    AWAITING_SHIPMENT("2"),
    SHIPPED("3"),
    DELIVERED("4");

    String orderStatus;

    OrderStatusEnum(String orderStatus){
        this.orderStatus = orderStatus;
    }

}
