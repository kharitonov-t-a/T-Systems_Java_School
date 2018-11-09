package com.web.shop.service.interfaces.products;

import com.web.shop.dto.products.CheckboxCharacteristicValuesDTO;
import com.web.shop.dto.products.ProductCharacteristicDTO;
import com.web.shop.service.GenericService;

import java.util.List;

public interface ProductCharacteristicService extends GenericService<ProductCharacteristicDTO, Integer> {
    List<ProductCharacteristicDTO> findByProductId(Integer idProduct);
}
