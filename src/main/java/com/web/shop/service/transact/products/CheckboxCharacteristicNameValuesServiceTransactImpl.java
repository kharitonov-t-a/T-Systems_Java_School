package com.web.shop.service.transact.products;

import com.web.shop.dao.products.CheckboxCharacteristicNameValuesDao;
import com.web.shop.dto.products.CheckboxCharacteristicNameValuesDTO;
import com.web.shop.model.products.CheckboxCharacteristicNameValues;
import com.web.shop.model.products.ProductCharacteristicType;
import com.web.shop.service.interfaces.products.CheckboxCharacteristicNameValuesService;
import com.web.shop.service.interfaces.products.ProductCharacteristicTypeService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.springframework.stereotype.Service;

@Service("checkboxCharacteristicNameValuesServiceTransact")
public class CheckboxCharacteristicNameValuesServiceTransactImpl extends GenericServiceTransactImpl<CheckboxCharacteristicNameValuesDTO, Integer, CheckboxCharacteristicNameValuesDao, CheckboxCharacteristicNameValues> implements CheckboxCharacteristicNameValuesService {
}
