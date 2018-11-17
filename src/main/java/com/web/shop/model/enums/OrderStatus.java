package com.web.shop.model.enums;

public enum OrderStatus {

    AWAITING_PAID("Awaiting paid"),
    AWAITING_SHIPMENT("Awaiting shipment"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered");

    String orderStatus;

    OrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
