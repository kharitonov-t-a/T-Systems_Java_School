package com.web.shop.service.front.products;

import com.web.shop.dto.products.ProductDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.products.ProductService;
import com.web.shop.service.interfaces.products.ProductsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceFront implements ProductService {


    @Autowired
    ProductService productService;

    @Override
    public ProductDTO findById(Integer id) {
        return productService.findById(id);
    }

    @Override
    public void create(ProductDTO productDTO) throws GlobalCustomException {
        productService.create(productDTO);
    }

    @Override
    public void delete(Integer id) throws GlobalCustomException {
        productService.delete(id);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }
}
