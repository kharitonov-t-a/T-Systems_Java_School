package com.web.shop.service.transact.orders;

import com.web.shop.dao.orders.OrderDao;
import com.web.shop.dao.orders.OrderProductDao;
import com.web.shop.dao.products.ProductDao;
import com.web.shop.dao.products.ProductsCategoryDao;
import com.web.shop.dao.users.AddressDao;
import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.orders.OrderProductDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.model.enums.OrderStatusEnum;
import com.web.shop.model.enums.PaymentStatusEnum;
import com.web.shop.model.orders.Order;
import com.web.shop.model.products.Product;
import com.web.shop.model.users.User;
import com.web.shop.service.interfaces.orders.OrderService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service("orderServiceTransact")
public class OrderServiceTransactImpl extends GenericServiceTransactImpl<OrderDTO, Integer, OrderDao, Order> implements OrderService {

    @Autowired
    ProductDao productDao;
    @Autowired
    AddressDao addressDao;

    @Override
    public List<OrderDTO> findByUserId(Integer userId) {
        return modelMapper.mapListsEntityToDTO(dao.findByUserId(userId), OrderDTO.class);
    }


    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Boolean checkoutOrder(OrderDTO orderSession, OrderDTO orderDTO, UserDTO userDTO) {

        List<Product> products = new ArrayList<>();

        // anti dead lock
        orderSession.getOrderProducts().sort(Comparator.comparing(o -> o.getProduct().getId()));

        Boolean anyProductNotInStock = false;
        for (OrderProductDTO orderProductDTO:orderSession.getOrderProducts()) {
            Product product = productDao.findByIdForUpdate(orderProductDTO.getProduct().getId());
            if(product.getStockQuantity() < 1) {
                orderProductDTO.setInStock(false);
                anyProductNotInStock = true;
            }else{
                products.add(product);
            }
        }

        if(anyProductNotInStock){
            orderSession.getOrderProducts().sort(Comparator.comparing(o -> o.getProduct().getName()));
            return false;
        }

        orderSession.setAddress(orderDTO.getAddress());
        orderSession.setDeliveryEnum(orderDTO.getDeliveryEnum());
        orderSession.setPaymentEnum(orderDTO.getPaymentEnum());

        products.forEach((i)->{
            i.setStockQuantity(i.getStockQuantity() - 1);
            productDao.update(i);
        });

        orderSession.getAddress().setUser(userDTO);

        orderSession.setUser(userDTO);


        orderSession.setOrderStatusEnum(OrderStatusEnum.AWAITING_PAID);
        orderSession.setPaymentStatusEnum(PaymentStatusEnum.AWAITING);

        Order order = modelMapper.map(orderSession, Order.class);

        addressDao.create(order.getAddress());
        dao.create(order);

        return true;
    }
}
