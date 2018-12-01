package com.web.shop.service.interfaces.product;

import com.web.shop.dto.product.ProductDTO;
import com.web.shop.service.GenericService;

import java.util.List;

public interface ProductService extends GenericService<ProductDTO, Integer> {
    List<ProductDTO> findByFilter(ProductDTO productDTO);

//    ProductDTO findById(Integer id);
//
//    void create(ProductDTO productCharacteristicDTO);
//
//    void delete(Integer id);
//
//    List<ProductDTO> findAll();


}
