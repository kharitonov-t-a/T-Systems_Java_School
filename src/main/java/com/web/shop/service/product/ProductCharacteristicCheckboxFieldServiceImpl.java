package com.web.shop.service.product;

import com.web.shop.dao.product.ProductCharacteristicCheckboxFieldDao;
import com.web.shop.dto.product.ProductCharacteristicCheckboxFieldDTO;
import com.web.shop.model.product.ProductCharacteristicCheckboxField;
import com.web.shop.service.interfaces.product.ProductCharacteristicCheckboxFieldService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service("productCharacteristicCheckboxFieldService")
public class ProductCharacteristicCheckboxFieldServiceImpl extends GenericServiceImpl<ProductCharacteristicCheckboxFieldDTO, Integer, ProductCharacteristicCheckboxFieldDao, ProductCharacteristicCheckboxField> implements ProductCharacteristicCheckboxFieldService {
}
