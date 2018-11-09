package com.web.shop.service.transact.orders;

import com.web.shop.dao.orders.OrderDao;
import com.web.shop.dao.orders.OrderProductDao;
import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.orders.OrderProductDTO;
import com.web.shop.model.orders.Order;
import com.web.shop.model.products.Product;
import com.web.shop.service.interfaces.orders.OrderProductService;
import com.web.shop.service.interfaces.orders.OrderService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.springframework.stereotype.Service;

@Service("orderProductServiceTransact")
public class OrderProductServiceTransactImpl extends GenericServiceTransactImpl<OrderProductDTO, Integer, OrderProductDao, Product> implements OrderProductService {
}
