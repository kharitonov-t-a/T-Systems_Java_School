package com.web.shop.service.product;

import com.web.shop.dao.product.ProductCharacteristicCheckboxValueDao;
import com.web.shop.dto.product.ProductCharacteristicCheckboxValueDTO;
import com.web.shop.model.product.ProductCharacteristicCheckboxValue;
import com.web.shop.service.interfaces.product.ProductCharacteristicCheckboxValueService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service("productCharacteristicCheckboxValueService")
public class ProductCharacteristicCheckboxValueServiceImpl extends GenericServiceImpl<ProductCharacteristicCheckboxValueDTO, Integer, ProductCharacteristicCheckboxValueDao, ProductCharacteristicCheckboxValue> implements ProductCharacteristicCheckboxValueService {
}
