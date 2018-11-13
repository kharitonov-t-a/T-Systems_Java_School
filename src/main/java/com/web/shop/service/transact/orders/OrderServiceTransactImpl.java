package com.web.shop.service.transact.orders;

import com.web.shop.dao.orders.OrderDao;
import com.web.shop.dao.orders.OrderProductDao;
import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.model.orders.Order;
import com.web.shop.model.products.Product;
import com.web.shop.model.users.User;
import com.web.shop.service.interfaces.orders.OrderService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderServiceTransact")
public class OrderServiceTransactImpl extends GenericServiceTransactImpl<OrderDTO, Integer, OrderDao, Order> implements OrderService {
    @Override
    public List<OrderDTO> findByUserId(Integer userId) {
        return modelMapper.mapListsEntityToDTO(dao.findByUserId(userId), OrderDTO.class);
    }
}
