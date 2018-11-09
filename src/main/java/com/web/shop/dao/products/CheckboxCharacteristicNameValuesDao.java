package com.web.shop.dao.products;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.products.CheckboxCharacteristicNameValues;

public interface CheckboxCharacteristicNameValuesDao extends GenericDao<CheckboxCharacteristicNameValues, Integer> {
    void deleteByProductCharacteristicTypeId(Integer id);
}
