package com.web.shop.service.transact.products;

import com.web.shop.dao.products.CheckboxCharacteristicNameValuesDao;
import com.web.shop.dao.products.CheckboxCharacteristicValuesDao;
import com.web.shop.dto.products.CheckboxCharacteristicNameValuesDTO;
import com.web.shop.dto.products.CheckboxCharacteristicValuesDTO;
import com.web.shop.model.products.CheckboxCharacteristicNameValues;
import com.web.shop.model.products.CheckboxCharacteristicValues;
import com.web.shop.service.interfaces.products.CheckboxCharacteristicNameValuesService;
import com.web.shop.service.interfaces.products.CheckboxCharacteristicValuesService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.springframework.stereotype.Service;

@Service("checkboxCharacteristicValuesServiceTransact")
public class CheckboxCharacteristicValuesServiceTransactImpl extends GenericServiceTransactImpl<CheckboxCharacteristicValuesDTO, Integer, CheckboxCharacteristicValuesDao, CheckboxCharacteristicValues> implements CheckboxCharacteristicValuesService {
}
