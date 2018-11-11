package com.web.shop.model.orders;

import com.web.shop.model.users.Address;
import com.web.shop.model.users.User;
import com.web.shop.model.enums.DeliveryEnum;
import com.web.shop.model.enums.OrderStatusEnum;
import com.web.shop.model.enums.PaymentEnum;
import com.web.shop.model.enums.PaymentStatusEnum;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "AddressId", nullable = false)
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

    @OneToMany(mappedBy="order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;

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

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", user=" + user +
//                ", address=" + address +
//                ", paymentEnum=" + paymentEnum +
//                ", deliveryEnum=" + deliveryEnum +
//                ", paymentStatusEnum=" + paymentStatusEnum +
//                ", orderStatusEnum=" + orderStatusEnum +
//                ", orderProducts=" + orderProducts +
//                '}';
//    }
}
