package com.web.shop.dto.order;

import com.web.shop.dto.user.UserAddressDTO;
import com.web.shop.dto.user.UserDTO;
import com.web.shop.model.enums.DeliveryType;
import com.web.shop.model.enums.OrderStatus;
import com.web.shop.model.enums.PaymentType;
import com.web.shop.model.enums.PaymentStatus;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO implements Serializable {

    private Integer id;

    @Valid
    private UserDTO user;

    @Valid
    private UserAddressDTO userAddress;

    private PaymentType paymentType;

    private DeliveryType deliveryType;

    private PaymentStatus paymentStatus;

    private OrderStatus orderStatus;

    private List<OrderProductDTO> orderProductList = new ArrayList<>();

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

    public UserAddressDTO getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddressDTO userAddress) {
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
