package com.web.shop.model.enums;

public enum PaymentStatusEnum {

    AWAITING("1"),
    PAID("2");

    String paymentStatus;

    PaymentStatusEnum(String paymentStatus){
        this.paymentStatus = paymentStatus;
    }

}
