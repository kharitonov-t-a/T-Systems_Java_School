package com.web.shop.dao.product;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.product.ProductCharacteristic;

import java.util.List;

public interface ProductCharacteristicDao extends GenericDao<ProductCharacteristic, Integer> {
    List<ProductCharacteristic> findByProductId(Integer productId);
}
