package com.web.shop.service.front.products;

import com.web.shop.dto.products.CheckboxCharacteristicValuesDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.products.CheckboxCharacteristicNameValuesService;
import com.web.shop.service.interfaces.products.CheckboxCharacteristicValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("checkboxCharacteristicValuesService")
public class CheckboxCharacteristicValuesServiceFront implements CheckboxCharacteristicValuesService {

    @Autowired
    CheckboxCharacteristicValuesService checkboxCharacteristicValuesServiceTransact;

    @Override
    public CheckboxCharacteristicValuesDTO findById(Integer id) {
        return checkboxCharacteristicValuesServiceTransact.findById(id);
    }

    @Override
    public void create(CheckboxCharacteristicValuesDTO checkboxCharacteristicValuesDTO) throws GlobalCustomException {
        checkboxCharacteristicValuesServiceTransact.create(checkboxCharacteristicValuesDTO);
    }

    @Override
    public void delete(Integer id) throws GlobalCustomException {
        checkboxCharacteristicValuesServiceTransact.delete(id);
    }

    @Override
    public List<CheckboxCharacteristicValuesDTO> findAll() {
        return checkboxCharacteristicValuesServiceTransact.findAll();
    }
}
