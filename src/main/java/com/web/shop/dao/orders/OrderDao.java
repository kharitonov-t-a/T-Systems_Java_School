package com.web.shop.dao.orders;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.orders.Order;
import com.web.shop.model.users.Address;

import java.util.List;

public interface OrderDao extends GenericDao<Order, Integer> {
    List<Order> findByUserId(Integer userId);
}
