package com.web.shop.service.product;

import com.web.shop.dao.product.ProductCharacteristicTypeDao;
import com.web.shop.dto.product.ProductCharacteristicTypeDTO;
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
//    @Autowired
//    ProductCharacteristicCheckboxFieldDao productCharacteristicCheckboxFieldDao;
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

    public List<ProductCharacteristicTypeDTO> findAll() {
        List<ProductCharacteristicTypeDTO> listProductCharacteristicTypeDTO = productCharacteristicTypeService.findAll();
        listProductCharacteristicTypeDTO.sort(Comparator.comparing(ProductCharacteristicTypeDTO::getCharacteristicType));
        return listProductCharacteristicTypeDTO;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductCharacteristicTypeDTO productCharacteristicDTO) {
        ProductCharacteristicType productCharacteristicType = modelMapper.map(productCharacteristicDTO, ProductCharacteristicType.class);
        dao.create(productCharacteristicType);
        if(productCharacteristicType.getId() != null){
//            listCheckboxCharacteristicNameValues.forEach((i)-> productCharacteristicCheckboxFieldDao.create(i));
        }
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
