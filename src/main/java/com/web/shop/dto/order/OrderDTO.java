package com.web.shop.dto.order;

import com.web.shop.dto.user.UserAddressDTO;
import com.web.shop.dto.user.UserDTO;
import com.web.shop.model.enums.DeliveryType;
import com.web.shop.model.enums.OrderStatus;
import com.web.shop.model.enums.PaymentType;
import com.web.shop.model.enums.PaymentStatus;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public class OrderDTO implements Serializable {

    private Integer id;

    private UserDTO user;

    @Valid
    private UserAddressDTO address;

    private PaymentType paymentType;

    private DeliveryType deliveryType;

    private PaymentStatus paymentStatus;

    private OrderStatus orderStatus;

    private List<OrderProductDTO> orderProductList;

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

    public UserAddressDTO getAddress() {
        return address;
    }

    public void setAddress(UserAddressDTO address) {
        this.address = address;
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

    public List<OrderProductDTO> getOrderProductList() {
        return orderProductList;
    }

    public void addProductToOrderList(OrderProductDTO orderProductDTO) {
        this.orderProductList.add(orderProductDTO);
    }

    public void setOrderProductList(List<OrderProductDTO> orderProductList) {
        this.orderProductList = orderProductList;
    }

//    @Override
//    public String toString() {
//        return "OrderDTO{" +
//                "id=" + id +
//                ", user=" + user +
//                ", address=" + address +
//                ", paymentType=" + paymentType +
//                ", deliveryType=" + deliveryType +
//                ", paymentStatus=" + paymentStatus +
//                ", orderStatus=" + orderStatus +
//                ", orderProductList=" + orderProductList +
//                '}';
//    }
}
