package com.web.shop.service.transact.products;

import com.web.shop.dao.products.ProductDao;
import com.web.shop.dao.products.ProductsCategoryDao;
import com.web.shop.dto.products.ProductCharacteristicTypeDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.model.products.Product;
import com.web.shop.model.products.ProductCharacteristicType;
import com.web.shop.model.products.ProductsCategory;
import com.web.shop.service.interfaces.products.ProductService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("productServiceTransact")
public class ProductServiceTransactImpl extends GenericServiceTransactImpl<ProductDTO, Integer, ProductDao, Product> implements ProductService {

    @Autowired
    ProductsCategoryDao productsCategoryDao;
//    @Autowired
//    CustomModelMapper<ProductDTO, Product> modelMapper;
//
//
//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public ProductDTO findById(int id) {
//        return modelMapper.map(dao.findById(id), ProductDTO.class);
//    }
//
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductDTO productDTO) {
        if(productDTO.getProductsCategory() == null)
            productDTO.setProductsCategory(new ProductsCategoryDTO(productDTO.getProductsCategoryId()));
//            productDTO.setProductsCategory(modelMapper.map(productsCategoryDao.findById(productDTO.getProductsCategoryId()), ProductsCategoryDTO.class));
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.typeMap(ProductDTO.class, Product.class)
                .addMappings(m -> m.map(src -> src.getProductsCategory(), Product::setProductsCategory));

        Product product = modelMapper.map(productDTO, Product.class);
        dao.create(product);
        productDTO.setId(product.getId());
    }
//
//    public void delete(Integer id) {
//        dao.deleteById(id);
//    }
//
//    @Override
//    public List<ProductDTO> findAll() {
//        return modelMapper.mapListsEntityToDTO(dao.findAll(), ProductDTO.class);
//    }
}
