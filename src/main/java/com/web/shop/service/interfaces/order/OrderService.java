package com.web.shop.service.interfaces.order;

import com.web.shop.dto.order.OrderDTO;
import com.web.shop.dto.user.UserDTO;
import com.web.shop.exceptions.NoProductsInStockException;
import com.web.shop.service.GenericService;

import java.util.List;

public interface OrderService extends GenericService<OrderDTO, Integer> {

    default void addProductToOrder(OrderDTO orderDTO, Integer productId, Integer countProduct) throws NoProductsInStockException {return;}

    default void changeCountProductInOrder(OrderDTO orderDTO, Integer productId, Integer countProduct) throws NoProductsInStockException {return;}

    List<OrderDTO> findByUserId(Integer userId);

    Boolean checkoutOrder(OrderDTO orderSession, OrderDTO orderDTO);

    void deleteProductInOrder(OrderDTO orderDTO, Integer productId);

    void changeOrderStatus(Integer orderId, String orderStatus);
}
