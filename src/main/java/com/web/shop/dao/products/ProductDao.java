package com.web.shop.dao.products;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.orders.OrderProduct;
import com.web.shop.model.products.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product, Integer> {
    List<Product> findAllByIds(List<OrderProduct> orderProducts);

    Product findByIdForUpdate(Integer id);
}
