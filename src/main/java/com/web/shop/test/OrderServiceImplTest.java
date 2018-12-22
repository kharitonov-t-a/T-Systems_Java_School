package com.web.shop.test;

import com.web.shop.dto.order.OrderDTO;
import com.web.shop.dto.order.OrderProductDTO;
import com.web.shop.dto.user.UserDTO;
import com.web.shop.model.enums.DeliveryType;
import com.web.shop.model.enums.PaymentType;
import com.web.shop.model.product.Product;
import com.web.shop.service.interfaces.order.OrderService;
import com.web.shop.service.interfaces.product.ProductService;
import com.web.shop.service.interfaces.user.UserService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class OrderServiceImplTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(com.web.shop.service.order.OrderServiceImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    @org.junit.Test
    public void checkoutOrder() {
        OrderDTO orderSession = new OrderDTO();
        OrderDTO orderDTO = new OrderDTO();
        UserDTO userDTO = new UserDTO();

        OrderProductDTO orderProductDTO = new OrderProductDTO();
        orderProductDTO.setCount(30);
        orderProductDTO.setPrice(BigDecimal.valueOf(100));
        orderProductDTO.setOrder(orderDTO);
        orderProductDTO.setProduct(productService.findById(1));
        List<OrderProductDTO> orderProductDTOList = new ArrayList<>();
        orderProductDTOList.add(orderProductDTO);
        orderSession.setOrderProductList(orderProductDTOList);

        userDTO = userService.findById(1);
        orderDTO.setUser(userDTO);

        orderDTO.setUserAddress(userDTO.getUserAddressList().get(0));
        orderDTO.setDeliveryType(DeliveryType.COURIER);
        orderDTO.setPaymentType(PaymentType.BANK_CARD);

        Assert.assertEquals(true, orderService.checkoutOrder(orderSession, orderDTO));
    }
}
