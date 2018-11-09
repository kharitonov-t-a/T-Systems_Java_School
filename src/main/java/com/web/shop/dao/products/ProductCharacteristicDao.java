package com.web.shop.dao.products;

import com.web.shop.dao.GenericDao;
import com.web.shop.dto.products.ProductCharacteristicDTO;
import com.web.shop.model.products.ProductCharacteristic;

import java.util.List;

public interface ProductCharacteristicDao extends GenericDao<ProductCharacteristic, Integer> {
    List<ProductCharacteristic> findByProductId(Integer productId);
}
