package com.web.shop.service.order;

import com.web.shop.dao.order.OrderDao;
import com.web.shop.dao.product.ProductDao;
import com.web.shop.dao.user.AddressDao;
import com.web.shop.dto.order.OrderDTO;
import com.web.shop.dto.order.OrderProductDTO;
import com.web.shop.dto.product.ProductDTO;
import com.web.shop.dto.user.UserDTO;
import com.web.shop.exceptions.NoProductsInStockException;
import com.web.shop.model.enums.OrderStatus;
import com.web.shop.model.enums.PaymentStatus;
import com.web.shop.model.order.Order;
import com.web.shop.model.product.Product;
import com.web.shop.service.interfaces.order.OrderService;
import com.web.shop.service.interfaces.product.ProductService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl extends GenericServiceImpl<OrderDTO, Integer, OrderDao, Order> implements OrderService {

    @Autowired
    ProductDao productDao;
    @Autowired
    AddressDao addressDao;

    @Autowired
    ProductService productService;

    @Override
    public List<OrderDTO> findByUserId(Integer userId) {
        return modelMapper.mapListsEntityToDTO(dao.findByUserId(userId), OrderDTO.class);
    }


    public void addProductToOrder(OrderDTO orderDTO, Integer productId) throws NoProductsInStockException {

        ProductDTO productDTO = productService.findById(productId);
        if(productDTO.getStockQuantity() <= 0){
            throw new NoProductsInStockException("No product in stock", productDTO);
        }

        if(orderDTO.getOrderProductList() == null)
            orderDTO.setOrderProductList(new ArrayList<OrderProductDTO>());

        orderDTO.addProductToOrderList(new OrderProductDTO(orderDTO, productDTO, productDTO.getPrice()));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean checkoutOrder(OrderDTO orderSession, OrderDTO orderDTO, UserDTO userDTO) {

        List<Product> products = new ArrayList<>();

        // anti dead lock
        orderSession.getOrderProductList().sort(Comparator.comparing(o -> o.getProduct().getId()));

        Boolean anyProductNotInStock = false;
        for (OrderProductDTO orderProductDTO:orderSession.getOrderProductList()) {
            Product product = productDao.findByIdForUpdate(orderProductDTO.getProduct().getId());
            if(product.getStockQuantity() < 1) {
                orderProductDTO.setInStock(false);
                anyProductNotInStock = true;
            }else{
                products.add(product);
            }
        }

        if(anyProductNotInStock){
            return false;
        }

        orderSession.setAddress(orderDTO.getAddress());
        orderSession.setDeliveryType(orderDTO.getDeliveryType());
        orderSession.setPaymentType(orderDTO.getPaymentType());

        products.forEach((i)->{
            i.setStockQuantity(i.getStockQuantity() - 1);
            productDao.update(i);
        });

        orderSession.getOrderProductList().sort(Comparator.comparing(o -> o.getProduct().getName()));

        orderSession.getAddress().setUser(userDTO);

        orderSession.setUser(userDTO);


        orderSession.setOrderStatus(OrderStatus.AWAITING_PAID);
        orderSession.setPaymentStatus(PaymentStatus.AWAITING);

        Order order = modelMapper.map(orderSession, Order.class);

        addressDao.create(order.getUserAddress());
        dao.create(order);

        return true;
    }
}
