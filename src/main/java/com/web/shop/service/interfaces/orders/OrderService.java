package com.web.shop.service.interfaces.orders;

import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.exceptions.NoProductsInStockException;
import com.web.shop.model.orders.Order;
import com.web.shop.model.products.Product;
import com.web.shop.model.users.User;
import com.web.shop.service.GenericService;

import java.util.List;

public interface OrderService extends GenericService<OrderDTO, Integer> {

    default void addProductToOrder(OrderDTO orderDTO, Integer productId) throws NoProductsInStockException {return;};

    List<OrderDTO> findByUserId(Integer userId);
}
