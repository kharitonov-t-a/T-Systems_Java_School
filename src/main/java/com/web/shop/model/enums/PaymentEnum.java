package com.web.shop.model.enums;

public enum PaymentEnum {

    CASH("Cash"),
    BANK_CARD("Bank card");

    String payment;

    PaymentEnum(String payment){
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
