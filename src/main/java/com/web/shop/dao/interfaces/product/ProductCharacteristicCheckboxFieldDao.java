package com.web.shop.dao.interfaces.product;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.product.ProductCharacteristicCheckboxField;

public interface ProductCharacteristicCheckboxFieldDao extends GenericDao<ProductCharacteristicCheckboxField, Integer> {
    void deleteByProductCharacteristicTypeId(Integer id);
}
