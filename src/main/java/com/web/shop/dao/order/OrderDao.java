package com.web.shop.dao.order;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.order.Order;

import java.util.List;

public interface OrderDao extends GenericDao<Order, Integer> {
    List<Order> findByUserId(Integer userId);
}
