package com.web.shop.controler.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.shop.converter.CustomModelMapper;
import com.web.shop.dto.product.ProductDTO;
import com.web.shop.dto.product.ProductDTORest;
import com.web.shop.service.interfaces.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;
    @Autowired
    protected CustomModelMapper<ProductDTORest, ProductDTO> modelMapper;

    private static ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("product/rest/getproducts")
    public String productList(ModelMap model) throws JsonProcessingException {
        List<ProductDTO> productDTOList = productService.findAll();
        List<ProductDTORest> productDTORestList = modelMapper.mapListsEntityToDTO(productDTOList, ProductDTORest.class);
        Collections.reverse(productDTORestList);
        return mapper.writeValueAsString(productDTORestList.subList(0, productDTORestList.size()>9?9:productDTORestList.size() - 1));
    }
}