package com.web.shop.dao.product;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.product.ProductCharacteristicType;

import java.util.List;

public interface ProductCharacteristicTypeDao extends GenericDao<ProductCharacteristicType, Integer> {
    List<ProductCharacteristicType> findByType(String Type);
}
