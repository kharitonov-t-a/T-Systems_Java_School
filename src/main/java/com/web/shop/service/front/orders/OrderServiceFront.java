package com.web.shop.service.front.orders;

import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.orders.OrderProductDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.exceptions.NoProductsInStockException;
import com.web.shop.model.orders.Order;
import com.web.shop.model.products.Product;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.orders.OrderService;
import com.web.shop.service.interfaces.products.ProductService;
import com.web.shop.service.interfaces.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("orderService")
public class OrderServiceFront implements OrderService {

    @Autowired
    OrderService orderServiceTransact;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    public OrderDTO findById(Integer id) {
        return orderServiceTransact.findById(id);
    }

    public void create(OrderDTO orderDTO) throws GlobalCustomException {
        orderServiceTransact.create(orderDTO);
    }

    public void delete(Integer id) throws GlobalCustomException {
        orderServiceTransact.delete(id);
    }

    public List<OrderDTO> findAll() {
        return orderServiceTransact.findAll();
    }

    public void addProductToOrder(OrderDTO orderDTO, Integer productId) throws NoProductsInStockException {
        ProductDTO productDTO = productService.findById(productId);
        if(productDTO.getStockQuantity() <= 0){
            throw new NoProductsInStockException("No product in stock", productDTO);
        }
        if(orderDTO.getOrderProducts() == null)
            orderDTO.setOrderProducts(new ArrayList<OrderProductDTO>());
        orderDTO.setOrderProductToList(new OrderProductDTO(orderDTO, productDTO, productDTO.getPrice()));
    }

    @Override
    public List<OrderDTO> findByUserId(Integer userId) {
        return orderServiceTransact.findByUserId(userId);
    }


}
