package com.web.shop.model.Orders;

import com.web.shop.model.Users.Address;
import com.web.shop.model.Users.User;
import com.web.shop.model.enums.DeliveryEnum;
import com.web.shop.model.enums.OrderStatusEnum;
import com.web.shop.model.enums.PaymentEnum;
import com.web.shop.model.enums.PaymentStatusEnum;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY) //EAGER
    @JoinColumn(name = "UserId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) //EAGER
    @JoinColumn(name = "UserAddress", nullable = false)
    private Address address;

    @Column(name = "Payment")
    @Enumerated(EnumType.STRING)
    private PaymentEnum paymentEnum;

    @Column(name = "Delivery")
    @Enumerated(EnumType.STRING)
    private DeliveryEnum deliveryEnum;

    @Column(name = "PaymentStatus")
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatusEnum;

    @Column(name = "OrderStatus")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatusEnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PaymentEnum getPaymentEnum() {
        return paymentEnum;
    }

    public void setPaymentEnum(PaymentEnum paymentEnum) {
        this.paymentEnum = paymentEnum;
    }

    public DeliveryEnum getDeliveryEnum() {
        return deliveryEnum;
    }

    public void setDeliveryEnum(DeliveryEnum deliveryEnum) {
        this.deliveryEnum = deliveryEnum;
    }

    public PaymentStatusEnum getPaymentStatusEnum() {
        return paymentStatusEnum;
    }

    public void setPaymentStatusEnum(PaymentStatusEnum paymentStatusEnum) {
        this.paymentStatusEnum = paymentStatusEnum;
    }

    public OrderStatusEnum getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
    }
}
