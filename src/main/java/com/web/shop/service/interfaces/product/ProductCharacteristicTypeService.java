package com.web.shop.service.interfaces.product;

import com.web.shop.dto.product.ProductCharacteristicTypeDTO;
import com.web.shop.model.product.ProductCharacteristicType;
import com.web.shop.service.GenericService;

import java.util.List;

public interface ProductCharacteristicTypeService extends GenericService<ProductCharacteristicTypeDTO, Integer> {
    List<ProductCharacteristicTypeDTO> findByCatalogId(Integer catalogId);
}
