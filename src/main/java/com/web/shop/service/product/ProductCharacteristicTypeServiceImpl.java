package com.web.shop.service.product;

import com.web.shop.dao.product.ProductCharacteristicCheckboxFieldDao;
import com.web.shop.dao.product.ProductCharacteristicTypeDao;
import com.web.shop.dto.product.ProductCharacteristicTypeDTO;
import com.web.shop.model.product.ProductCharacteristicCheckboxField;
import com.web.shop.model.product.ProductCharacteristicType;
import com.web.shop.service.interfaces.product.ProductCharacteristicTypeService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service("productCharacteristicTypeService")
public class ProductCharacteristicTypeServiceImpl extends GenericServiceImpl<ProductCharacteristicTypeDTO, Integer, ProductCharacteristicTypeDao,ProductCharacteristicType> implements ProductCharacteristicTypeService {

//    @Autowired
//    CustomModelMapper<ProductCharacteristicTypeDTO, ProductCharacteristicType> modelMapper;
//
    @Autowired
    ProductCharacteristicCheckboxFieldDao productCharacteristicCheckboxFieldDao;
    @Autowired
    ProductCharacteristicTypeService productCharacteristicTypeService;

//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public ProductCharacteristicTypeDTO findById(int id) {
//        return modelMapper.map(dao.findById(id), ProductCharacteristicTypeDTO.class);
//    }

//    @Override
//    public ProductCharacteristicTypeDTO findById(Integer id) {
//        return null;
//    }
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductCharacteristicTypeDTO> findAll() {
        List<ProductCharacteristicType> productCharacteristicTypeList = dao.findAll();
        productCharacteristicTypeList.sort(Comparator.comparing(ProductCharacteristicType::getCharacteristicType));
        return modelMapper.mapListsEntityToDTO(productCharacteristicTypeList, ProductCharacteristicTypeDTO.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductCharacteristicTypeDTO productCharacteristicDTO) {
        ProductCharacteristicType productCharacteristicType = modelMapper.map(productCharacteristicDTO, ProductCharacteristicType.class);
        if(productCharacteristicType.getProductCharacteristicCheckboxFieldList() != null){
            productCharacteristicType.getProductCharacteristicCheckboxFieldList().removeIf((i)->i.getValue() == null||i.getValue().isEmpty());
            productCharacteristicType.getProductCharacteristicCheckboxFieldList().forEach((i)->i.setProductCharacteristicType(productCharacteristicType));
        }
        dao.create(productCharacteristicType);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(ProductCharacteristicTypeDTO productCharacteristicTypeDTO) {

        ProductCharacteristicType productCharacteristicType = modelMapper.map(productCharacteristicTypeDTO, ProductCharacteristicType.class);
        ProductCharacteristicType productCharacteristicTypeExist = dao.findById(productCharacteristicType.getId());

        if(productCharacteristicType.getProductCharacteristicCheckboxFieldList() != null){
            productCharacteristicType.getProductCharacteristicCheckboxFieldList().removeIf((i)->i.getValue() == null||i.getValue().isEmpty());
            productCharacteristicType.getProductCharacteristicCheckboxFieldList().forEach((i)->i.setProductCharacteristicType(productCharacteristicTypeExist));
        }

        // delete deleted checkbox fields
        productCharacteristicType.getProductCharacteristicCheckboxFieldList().forEach((checkboxField)->
                productCharacteristicTypeExist.getProductCharacteristicCheckboxFieldList().removeIf((checkboxFieldExist)->checkboxFieldExist.getId() == checkboxField.getId()));
        productCharacteristicTypeExist.getProductCharacteristicCheckboxFieldList().forEach((i)->productCharacteristicCheckboxFieldDao.delete(i));

        dao.update(productCharacteristicType);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductCharacteristicTypeDTO> findByCatalogId(Integer catalogId) {
        List<ProductCharacteristicType> productCharacteristicType =dao.findByCatalogId(catalogId);
//        productCharacteristicType.forEach(i->{
//            if(i.getProductCharacteristicCheckboxFieldList().isEmpty())
//                i.getProductCharacteristicCheckboxFieldList().isEmpty();
//            if(i.getProductCharacteristicList().isEmpty())
//                i.getProductCharacteristicList().isEmpty();
//        });
        return modelMapper.mapListsEntityToDTO(productCharacteristicType, ProductCharacteristicTypeDTO.class);
    }

//    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
//    public void delete(Integer id) {
//        dao.deleteById(id);
//    }

//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public List<ProductCharacteristicTypeDTO> findAll() {
////        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
////        modelMapper.typeMap(ProductCharacteristicType.class, ProductCharacteristicTypeDTO.class)
////                .addMappings(m -> m.map(src -> src.getCheckboxCharacteristicNameValuesToString(), ProductCharacteristicTypeDTO::setCheckboxCharacteristicNameValuesString));
//        return modelMapper.mapListsEntityToDTO(dao.findAll(), ProductCharacteristicTypeDTO.class);
//
//
//
//    }


}
