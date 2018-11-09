package com.web.shop.dao.products;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.products.CheckboxCharacteristicNameValues;
import com.web.shop.model.products.CheckboxCharacteristicValues;
import org.springframework.stereotype.Repository;

@Repository("checkboxCharacteristicValuesDao")
public class CheckboxCharacteristicValuesDaoImpl extends GenericDaoImpl<CheckboxCharacteristicValues, Integer> implements CheckboxCharacteristicValuesDao {
}
