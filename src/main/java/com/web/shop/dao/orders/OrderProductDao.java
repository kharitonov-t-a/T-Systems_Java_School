package com.web.shop.dao.orders;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.orders.OrderProduct;
import com.web.shop.model.products.Product;

import java.util.List;

public interface OrderProductDao extends GenericDao<Product, Integer> {
    @Override
    void create(Product newInstance);
}
