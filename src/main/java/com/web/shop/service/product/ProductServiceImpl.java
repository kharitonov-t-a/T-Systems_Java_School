package com.web.shop.service.product;

import com.web.shop.converter.CustomModelMapper;
import com.web.shop.dao.product.ProductDao;
import com.web.shop.dto.product.ProductCharacteristicDTO;
import com.web.shop.dto.product.ProductDTO;
import com.web.shop.model.product.Product;
import com.web.shop.model.product.ProductCharacteristic;
import com.web.shop.service.interfaces.product.ProductService;
import com.web.shop.service.GenericServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service("productService")
public class ProductServiceImpl extends GenericServiceImpl<ProductDTO, Integer, ProductDao, Product> implements ProductService {

    @Autowired
    ProductService productService;

    @Autowired
    CustomModelMapper<ProductCharacteristic, ProductCharacteristicDTO> modelMapperCharacteristic;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductDTO productDTO) {
        productDTO.getProductCharacteristicList().removeIf((i)->i.getProductCharacteristicType() == null);
        productDTO.getProductCharacteristicList().forEach((i)->i.getProductCharacteristicCheckboxValueList().removeIf((l)->l.getProductCharacteristicCheckboxField() == null));
//        productDTO.getProductCharacteristicList().forEach((i)->i.setProduct(productDTO));
        List<ProductCharacteristicDTO> productCharacteristicList = productDTO.getProductCharacteristicList();
        productDTO.setProductCharacteristicList(new ArrayList<>());
        Product product = modelMapper.map(productDTO, Product.class);
//        modelMapper.mapListsEntityToDTO(productCharacteristicList, ProductCharacteristicDTO.class);
        productCharacteristicList.forEach(i->i.setProductCharacteristicType(null));
        product.setProductCharacteristicList(modelMapperCharacteristic.mapListsEntityToDTO(productCharacteristicList, ProductCharacteristic.class));
//        dao.create(product);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductDTO> findAll() {
        List<Product> productDTOList = dao.findAll();
        productDTOList.sort(Comparator.comparing(o -> o.getProductCategory().getLeftKey()));
        return  modelMapper.mapListsEntityToDTO(productDTOList, ProductDTO.class);
    }

}
