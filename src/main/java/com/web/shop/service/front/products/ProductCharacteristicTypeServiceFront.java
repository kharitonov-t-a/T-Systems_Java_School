package com.web.shop.service.front.products;

import com.web.shop.dto.products.ProductCharacteristicTypeDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.products.ProductCharacteristicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service("productCharacteristicTypeService")
public class ProductCharacteristicTypeServiceFront implements ProductCharacteristicTypeService {

    @Autowired
    ProductCharacteristicTypeService productCharacteristicTypeServiceTransact;

    public ProductCharacteristicTypeDTO findById(Integer id) {
        return productCharacteristicTypeServiceTransact.findById(id);
    }

    public void create(ProductCharacteristicTypeDTO productCharacteristicTypeDTO) throws GlobalCustomException {
        productCharacteristicTypeServiceTransact.create(productCharacteristicTypeDTO);
    }

    public void delete(Integer id) throws GlobalCustomException {
        productCharacteristicTypeServiceTransact.delete(id);
    }

    public List<ProductCharacteristicTypeDTO> findAll() {
        List<ProductCharacteristicTypeDTO> listProductCharacteristicTypeDTO = productCharacteristicTypeServiceTransact.findAll();
        listProductCharacteristicTypeDTO.sort(Comparator.comparing(ProductCharacteristicTypeDTO::getCharacteristicType));
        return listProductCharacteristicTypeDTO;
    }
}
