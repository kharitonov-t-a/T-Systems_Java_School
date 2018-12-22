package com.web.shop.dao.interfaces.product;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.order.OrderProduct;
import com.web.shop.model.product.Product;
import com.web.shop.model.product.ProductCategory;

import java.util.List;

public interface ProductDao extends GenericDao<Product, Integer> {
    List<Product> findAllByIds(List<OrderProduct> orderProducts);

    Product findByIdForUpdate(Integer id);

    void setCategoryToNull(Integer categoryId);

    List<Product> findByFilter(Product product);
}
