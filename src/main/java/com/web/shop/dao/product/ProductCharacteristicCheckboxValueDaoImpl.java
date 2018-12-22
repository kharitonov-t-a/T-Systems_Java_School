package com.web.shop.dao.product;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.dao.interfaces.product.ProductCharacteristicCheckboxValueDao;
import com.web.shop.model.product.ProductCharacteristicCheckboxValue;
import org.springframework.stereotype.Repository;

@Repository("productCharacteristicCheckboxValueDao")
public class ProductCharacteristicCheckboxValueDaoImpl extends GenericDaoImpl<ProductCharacteristicCheckboxValue, Integer> implements ProductCharacteristicCheckboxValueDao {
}
