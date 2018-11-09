package com.web.shop.service.transact.orders;

import com.web.shop.dao.orders.OrderDao;
import com.web.shop.dao.users.AddressDao;
import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.users.AddressDTO;
import com.web.shop.model.orders.Order;
import com.web.shop.model.users.Address;
import com.web.shop.service.interfaces.orders.OrderService;
import com.web.shop.service.interfaces.users.AddressService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.springframework.stereotype.Service;

@Service("orderServiceTransact")
public class OrderServiceTransactImpl extends GenericServiceTransactImpl<OrderDTO, Integer, OrderDao, Order> implements OrderService {
}
