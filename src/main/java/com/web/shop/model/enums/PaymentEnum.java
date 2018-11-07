package com.web.shop.model.enums;

public enum PaymentEnum {

    CASH("1"),
    BANK_CARD("2");

    String payment;

    PaymentEnum(String payment){
        this.payment = payment;
    }

}
