package com.web.shop.dto.orders;

import com.web.shop.dto.users.AddressDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.model.enums.DeliveryEnum;
import com.web.shop.model.enums.OrderStatusEnum;
import com.web.shop.model.enums.PaymentEnum;
import com.web.shop.model.enums.PaymentStatusEnum;
import com.web.shop.model.orders.OrderProduct;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class OrderDTO implements Serializable {

    private Integer id;

    private UserDTO user;

    @Valid
    private AddressDTO address;

    private PaymentEnum paymentEnum;

    private DeliveryEnum deliveryEnum;

    private PaymentStatusEnum paymentStatusEnum;

    private OrderStatusEnum orderStatusEnum;

    private List<OrderProductDTO> orderProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
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

    public List<OrderProductDTO> getOrderProducts() {
        return orderProducts;
    }
    public void setOrderProductToList(OrderProductDTO orderProductDTO) {
        this.orderProducts.add(orderProductDTO);
    }

    public void setOrderProducts(List<OrderProductDTO> orderProducts) {
        this.orderProducts = orderProducts;
    }

//    @Override
//    public String toString() {
//        return "OrderDTO{" +
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
