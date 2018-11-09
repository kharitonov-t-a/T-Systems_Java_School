package com.web.shop.service.front.orders;

import com.web.shop.dto.orders.OrderProductDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.orders.OrderProductService;
import com.web.shop.service.interfaces.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderProductService")
public class OrderProductServiceFront implements OrderProductService {

    @Autowired
    OrderProductService orderProductServiceTransact;

    @Override
    public OrderProductDTO findById(Integer id) {
        return orderProductServiceTransact.findById(id);
    }

    @Override
    public void create(OrderProductDTO orderProductDTO) throws GlobalCustomException {
        orderProductServiceTransact.create(orderProductDTO);
    }

    @Override
    public void delete(Integer id) throws GlobalCustomException {
        orderProductServiceTransact.delete(id);
    }

    @Override
    public List<OrderProductDTO> findAll() {
        return orderProductServiceTransact.findAll();
    }
}
