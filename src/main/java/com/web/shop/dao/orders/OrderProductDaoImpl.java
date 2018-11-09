package com.web.shop.dao.orders;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.orders.Order;
import com.web.shop.model.products.Product;
import org.springframework.stereotype.Repository;

@Repository("orderProductDao")
public class OrderProductDaoImpl extends GenericDaoImpl<Product, Integer> implements OrderProductDao{
}
