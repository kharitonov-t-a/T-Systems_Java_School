package com.web.shop.service.interfaces.product;

import com.web.shop.dto.product.ProductCharacteristicDTO;
import com.web.shop.service.GenericService;

import java.util.List;

public interface ProductCharacteristicService extends GenericService<ProductCharacteristicDTO, Integer> {
    List<ProductCharacteristicDTO> findByProductId(Integer idProduct);
}
