package com.web.shop.service.front.orders;

import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.orders.OrderService;
import com.web.shop.service.interfaces.users.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceFront implements OrderService {

    @Autowired
    OrderService orderServiceTransact;

    @Override
    public OrderDTO findById(Integer id) {
        return orderServiceTransact.findById(id);
    }

    @Override
    public void create(OrderDTO orderDTO) throws GlobalCustomException {
        orderServiceTransact.create(orderDTO);
    }

    @Override
    public void delete(Integer id) throws GlobalCustomException {
        orderServiceTransact.delete(id);
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderServiceTransact.findAll();
    }
}
