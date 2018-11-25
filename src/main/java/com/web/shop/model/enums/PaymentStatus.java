package com.web.shop.model.enums;

public enum PaymentStatus {

    AWAITING("Awaiting paid"),
    PAID("Paid");

    String paymentStatus;

    PaymentStatus(String paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
