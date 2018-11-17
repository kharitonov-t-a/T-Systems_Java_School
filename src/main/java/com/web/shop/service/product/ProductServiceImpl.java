package com.web.shop.service.product;

import com.web.shop.dao.product.ProductDao;
import com.web.shop.dto.product.ProductDTO;
import com.web.shop.model.product.Product;
import com.web.shop.service.interfaces.product.ProductService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service("productService")
public class ProductServiceImpl extends GenericServiceImpl<ProductDTO, Integer, ProductDao, Product> implements ProductService {

    @Autowired
    ProductService productService;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductDTO productDTO) {

        Product product = modelMapper.map(productDTO, Product.class);
        dao.create(product);
        productDTO.setId(product.getId());
    }

    public List<ProductDTO> findAll() {
        List<ProductDTO> productDTOList = productService.findAll();
        productDTOList.sort(Comparator.comparing(o -> o.getProductCategory().getLeftKey()));
        return productDTOList;
    }

}
