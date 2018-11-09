package com.web.shop.dao.orders;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.dao.users.AddressDao;
import com.web.shop.model.orders.Order;
import com.web.shop.model.users.Address;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl extends GenericDaoImpl<Order, Integer> implements OrderDao {
}
