package com.web.shop.dao.order;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.product.Product;
import org.springframework.stereotype.Repository;

@Repository("orderProductDao")
public class OrderProductDaoImpl extends GenericDaoImpl<Product, Integer> implements OrderProductDao {
}
