package com.web.shop.service.order;

import com.web.shop.dao.interfaces.order.OrderDao;
import com.web.shop.dao.interfaces.product.ProductDao;
import com.web.shop.dao.interfaces.user.AddressDao;
import com.web.shop.dao.interfaces.user.UserDao;
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
import com.web.shop.service.interfaces.user.UserAddressService;
import com.web.shop.service.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service("orderService")
public class OrderServiceImpl extends GenericServiceImpl<OrderDTO, Integer, OrderDao, Order> implements OrderService {

    @Autowired
    ProductDao productDao;
    @Autowired
    AddressDao addressDao;

    @Autowired
    ProductService productService;
    @Autowired
    UserAddressService userAddressService;
    @Autowired
    UserService userService;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<OrderDTO> findByUserId(Integer userId) {
        return modelMapper.mapListsEntityToDTO(dao.findByUserId(userId), OrderDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public void addProductToOrder(OrderDTO orderDTO, Integer productId, Integer countProduct) throws NoProductsInStockException {

        ProductDTO productDTO = productService.findById(productId);


        if(orderDTO.getOrderProductList() == null)
            orderDTO.setOrderProductList(new ArrayList<OrderProductDTO>());

        List<OrderProductDTO> orderProductDTOList = orderDTO.getOrderProductList().stream().filter(orderProductDTO -> orderProductDTO.getProduct().getId() == productDTO.getId()).collect(Collectors.toList());
        if(orderProductDTOList.size() > 0){
            if(productDTO.getStockQuantity() < countProduct + orderProductDTOList.get(0).getCount()){
                throw new NoProductsInStockException("So many products out of stock", productDTO);
            }
            orderProductDTOList.get(0).setCount(orderProductDTOList.get(0).getCount() + countProduct);

        } else{
            if(productDTO.getStockQuantity() < countProduct){
                throw new NoProductsInStockException("So many products out of stock", productDTO);
            }
            orderDTO.addProductToOrderList(new OrderProductDTO(orderDTO, productDTO, productDTO.getPrice(), countProduct));
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public void changeCountProductInOrder(OrderDTO orderDTO, Integer productId, Integer countProduct) throws NoProductsInStockException {

        List<OrderProductDTO> orderProductDTOList = orderDTO.getOrderProductList().stream().filter(orderProductDTO -> orderProductDTO.getProduct().getId() == productId).collect(Collectors.toList());
        if(orderProductDTOList.size() > 0)
            orderProductDTOList.get(0).setCount(orderProductDTOList.get(0).getCount() + countProduct);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean checkoutOrder(OrderDTO orderSession, OrderDTO orderDTO) {

        List<Product> products = new ArrayList<>();

        // anti dead lock
        orderSession.getOrderProductList().sort(Comparator.comparing(o -> o.getProduct().getId()));

        Boolean anyProductNotInStock = false;
        for (OrderProductDTO orderProductDTO:orderSession.getOrderProductList()) {
            Product product = productDao.findByIdForUpdate(orderProductDTO.getProduct().getId());
            if(product.getStockQuantity() < orderProductDTO.getCount()) {
                orderProductDTO.setInStock(false);
                anyProductNotInStock = true;
                orderProductDTO.setCount(product.getStockQuantity());
            }else{
                products.add(product);
            }
        }

        if(anyProductNotInStock){
            return false;
        }

        if(orderDTO.getUserAddress().getId() != null)
            orderSession.setUserAddress(userAddressService.findById(orderDTO.getUserAddress().getId()));
        else
            orderSession.setUserAddress(orderDTO.getUserAddress());
        orderSession.setDeliveryType(orderDTO.getDeliveryType());
        orderSession.setPaymentType(orderDTO.getPaymentType());

        products.forEach((i)->{
            i.setStockQuantity(i.getStockQuantity() - 1);
            productDao.update(i);
        });

        orderSession.getOrderProductList().sort(Comparator.comparing(o -> o.getProduct().getName()));

        if(orderDTO.getUser().getId() == null){
            userService.create(orderDTO.getUser());
            orderSession.getUserAddress().setUser(userService.findByEmail(orderDTO.getUser().getEmail()));
        }else
            orderSession.getUserAddress().setUser(orderDTO.getUser());

        orderSession.setUser(orderSession.getUserAddress().getUser());


        orderSession.setOrderStatus(OrderStatus.AWAITING_PAID);
        orderSession.setPaymentStatus(PaymentStatus.AWAITING);

        Order order = modelMapper.map(orderSession, Order.class);

        if(order.getUserAddress().getId() == null)
            addressDao.create(order.getUserAddress());
        dao.create(order);

        return true;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteProductInOrder(OrderDTO orderDTO, Integer productId) {
        orderDTO.getOrderProductList().removeIf(orderProductDTO -> orderProductDTO.getProduct().getId() == productId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeOrderStatus(Integer orderId, String orderStatus) {
        Order entity = dao.findById(orderId);
        switch (OrderStatus.valueOf(orderStatus)){
            case AWAITING_PAID:
                entity.setOrderStatus(OrderStatus.AWAITING_PAID);
                entity.setPaymentStatus(PaymentStatus.AWAITING);
                break;
            case AWAITING_SHIPMENT:
                entity.setOrderStatus(OrderStatus.AWAITING_SHIPMENT);
                entity.setPaymentStatus(PaymentStatus.PAID);
                break;
            case SHIPPED:
                entity.setOrderStatus(OrderStatus.SHIPPED);
                break;
            case DELIVERED:
                entity.setOrderStatus(OrderStatus.DELIVERED);
                break;
        }
    }
}
