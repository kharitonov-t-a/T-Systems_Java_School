package com.web.shop.service.front.products;

import com.web.shop.dto.products.CheckboxCharacteristicNameValuesDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.products.CheckboxCharacteristicNameValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("checkboxCharacteristicNameValuesService")
public class CheckboxCharacteristicNameValuesServiceFront implements CheckboxCharacteristicNameValuesService {

    @Autowired
    CheckboxCharacteristicNameValuesService checkboxCharacteristicNameValuesServiceTransact;

    @Override
    public CheckboxCharacteristicNameValuesDTO findById(Integer id) {
        return checkboxCharacteristicNameValuesServiceTransact.findById(id);
    }

    @Override
    public void create(CheckboxCharacteristicNameValuesDTO productDTO) throws GlobalCustomException {
        checkboxCharacteristicNameValuesServiceTransact.create(productDTO);
    }

    @Override
    public void delete(Integer id) throws GlobalCustomException {
        checkboxCharacteristicNameValuesServiceTransact.delete(id);
    }

    @Override
    public List<CheckboxCharacteristicNameValuesDTO> findAll() {
        return checkboxCharacteristicNameValuesServiceTransact.findAll();
    }
}
