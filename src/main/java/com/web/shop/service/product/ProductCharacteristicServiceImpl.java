package com.web.shop.service.product;

import com.web.shop.dao.product.ProductCharacteristicDao;
import com.web.shop.dto.product.*;
import com.web.shop.model.product.*;
import com.web.shop.service.interfaces.product.ProductCharacteristicService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productCharacteristicService")
public class ProductCharacteristicServiceImpl extends GenericServiceImpl<ProductCharacteristicDTO, Integer, ProductCharacteristicDao, ProductCharacteristic> implements ProductCharacteristicService {

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductCharacteristicDTO> findByProductId(Integer productId) {
        return modelMapper.mapListsEntityToDTO(dao.findByProductId(productId), ProductCharacteristicDTO.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductCharacteristicDTO productCharacteristicDTO) {
        productCharacteristicDTO.setId(null);
        dao.create(modelMapper.map(productCharacteristicDTO, ProductCharacteristic.class));
    }


}
