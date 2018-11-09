package com.web.shop.service.transact.products;

import com.web.shop.dao.products.ProductCharacteristicDao;
import com.web.shop.dto.products.*;
import com.web.shop.model.products.*;
import com.web.shop.service.interfaces.products.ProductCharacteristicService;
import com.web.shop.service.interfaces.products.ProductCharacteristicTypeService;
import com.web.shop.service.interfaces.products.ProductService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("productCharacteristicServiceTransact")
public class ProductCharacteristicServiceTransactImpl extends GenericServiceTransactImpl<ProductCharacteristicDTO, Integer, ProductCharacteristicDao, ProductCharacteristic> implements ProductCharacteristicService {

    @Autowired
    ProductCharacteristicTypeService productCharacteristicTypeService;

    @Autowired
    ProductService productService;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductCharacteristicDTO> findByProductId(Integer productId) {
        return modelMapper.mapListsEntityToDTO(dao.findByProductId(productId), ProductCharacteristicDTO.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductCharacteristicDTO productCharacteristicDTO) {
        productCharacteristicDTO.setProductCharacteristicType(productCharacteristicTypeService.findById(productCharacteristicDTO.getProductCharacteristicTypeId()));
        productCharacteristicDTO.setProduct(productService.findById(productCharacteristicDTO.getProductId()));
        productCharacteristicDTO.setId(null);

        List<CheckboxCharacteristicValuesDTO> checkboxCharacteristicValues = new ArrayList<>();
        productCharacteristicDTO.getCheckboxCharacteristicValuesInteger().forEach((i)-> {
            CheckboxCharacteristicValuesDTO checkboxCharacteristicValuesDTO = new CheckboxCharacteristicValuesDTO(i);
            checkboxCharacteristicValuesDTO.setProductCharacteristic(productCharacteristicDTO);
            checkboxCharacteristicValues.add(checkboxCharacteristicValuesDTO);
        });
        productCharacteristicDTO.setCheckboxCharacteristicValues(checkboxCharacteristicValues);

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.typeMap(ProductCharacteristicDTO.class, ProductCharacteristic.class)
                .addMappings(m -> m.map(src -> src.getProductCharacteristicType(), ProductCharacteristic::setProductCharacteristicType))
                .addMappings(m -> m.map(src -> src.getProduct(), ProductCharacteristic::setProduct))
                .addMappings(m -> m.map(src -> src.getCheckboxCharacteristicValues(), ProductCharacteristic::setCheckboxCharacteristicValues));

        dao.create(modelMapper.map(productCharacteristicDTO, ProductCharacteristic.class));
//        super.create(productCharacteristicDTO);
    }


}
