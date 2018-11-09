package com.web.shop.service.front.products;

import com.web.shop.dto.products.ProductCharacteristicDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.GenericService;
import com.web.shop.service.interfaces.products.CheckboxCharacteristicValuesService;
import com.web.shop.service.interfaces.products.ProductCharacteristicService;
import com.web.shop.service.interfaces.products.ProductCharacteristicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productCharacteristicService")
public class ProductCharacteristicServiceFront implements ProductCharacteristicService {

    @Autowired
    ProductCharacteristicService productCharacteristicServiceTransact;

    @Override
    public ProductCharacteristicDTO findById(Integer id) {
        return productCharacteristicServiceTransact.findById(id);
    }

    @Override
    public void create(ProductCharacteristicDTO productCharacteristicDTO) throws GlobalCustomException {
        productCharacteristicServiceTransact.create(productCharacteristicDTO);
    }

    @Override
    public void delete(Integer id) throws GlobalCustomException {
        productCharacteristicServiceTransact.delete(id);
    }

    @Override
    public List<ProductCharacteristicDTO> findAll() {
        return productCharacteristicServiceTransact.findAll();
    }

    @Override
    public List<ProductCharacteristicDTO> findByProductId(Integer idProduct) {
        return productCharacteristicServiceTransact.findByProductId(idProduct);
    }
}
