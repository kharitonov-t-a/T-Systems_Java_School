package com.web.shop.model.order;

import com.web.shop.model.enums.PaymentType;
import com.web.shop.model.enums.PaymentStatus;
import com.web.shop.model.user.UserAddress;
import com.web.shop.model.user.User;
import com.web.shop.model.enums.DeliveryType;
import com.web.shop.model.enums.OrderStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private UserAddress userAddress;

    @Column(name = "paymentType")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "deliveryType")
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    @Column(name = "paymentStatus")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "orderStatus")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy="order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderProduct> orderProductList;

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

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProduct> orderProductList) {
        this.orderProductList = orderProductList;
    }

    public void addOrderProduct(List<OrderProduct> orderProducts) {
        this.orderProductList = orderProducts;
    }

//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", user=" + user +
//                ", userAddress=" + userAddress +
//                ", paymentType=" + paymentType +
//                ", deliveryType=" + deliveryType +
//                ", paymentStatus=" + paymentStatus +
//                ", orderStatus=" + orderStatus +
//                ", orderProductList=" + orderProductList +
//                '}';
//    }
}
