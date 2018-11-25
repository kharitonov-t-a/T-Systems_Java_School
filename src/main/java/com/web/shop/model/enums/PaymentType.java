package com.web.shop.model.enums;

public enum PaymentType {

    CASH("Cash"),
    BANK_CARD("Bank card");

    String payment;

    PaymentType(String payment){
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }
}
