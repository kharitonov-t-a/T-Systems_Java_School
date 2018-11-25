package com.web.shop.service.order;

import com.web.shop.dao.order.OrderProductDao;
import com.web.shop.dto.order.OrderProductDTO;
import com.web.shop.model.product.Product;
import com.web.shop.service.interfaces.order.OrderProductService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service("orderProductService")
public class OrderProductServiceImpl extends GenericServiceImpl<OrderProductDTO, Integer, OrderProductDao, Product> implements OrderProductService {


}
