package com.web.shop.service.transact.products;

import com.web.shop.dao.products.CheckboxCharacteristicNameValuesDao;
import com.web.shop.dao.products.ProductCharacteristicTypeDao;
import com.web.shop.dto.products.ProductCharacteristicTypeDTO;
import com.web.shop.model.products.CheckboxCharacteristicNameValues;
import com.web.shop.model.products.ProductCharacteristicType;
import com.web.shop.service.interfaces.products.ProductCharacteristicTypeService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("productCharacteristicTypeServiceTransact")
public class ProductCharacteristicTypeServiceTransactImpl extends GenericServiceTransactImpl<ProductCharacteristicTypeDTO, Integer, ProductCharacteristicTypeDao,ProductCharacteristicType> implements ProductCharacteristicTypeService {

//    @Autowired
//    CustomModelMapper<ProductCharacteristicTypeDTO, ProductCharacteristicType> modelMapper;
//
    @Autowired
    CheckboxCharacteristicNameValuesDao checkboxCharacteristicNameValuesDao;

//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public ProductCharacteristicTypeDTO findById(int id) {
//        return modelMapper.map(dao.findById(id), ProductCharacteristicTypeDTO.class);
//    }

//    @Override
//    public ProductCharacteristicTypeDTO findById(Integer id) {
//        return null;
//    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductCharacteristicTypeDTO productCharacteristicDTO) {
        List<String> listValues = productCharacteristicDTO.getCheckboxCharacteristicNameValuesString();
        productCharacteristicDTO.setCheckboxCharacteristicNameValuesString(new ArrayList<String>());
        ProductCharacteristicType productCharacteristicType = modelMapper.map(productCharacteristicDTO, ProductCharacteristicType.class);
        List<CheckboxCharacteristicNameValues> listCheckboxCharacteristicNameValues= new ArrayList<>();
        listValues.remove(listValues.size() - 1);
        listValues.forEach((i)-> {if(i!=null || !i.isEmpty())listCheckboxCharacteristicNameValues.add(new CheckboxCharacteristicNameValues(i, productCharacteristicType));});
        productCharacteristicType.setCheckboxCharacteristicNameValues(listCheckboxCharacteristicNameValues);
        dao.create(productCharacteristicType);
        if(productCharacteristicType.getId() != null){

//            listCheckboxCharacteristicNameValues.forEach((i)-> checkboxCharacteristicNameValuesDao.create(i));
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductCharacteristicTypeDTO> findAll() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.typeMap(ProductCharacteristicType.class, ProductCharacteristicTypeDTO.class)
                .addMappings(m -> m.map(src -> src.getCheckboxCharacteristicNameValuesToString(), ProductCharacteristicTypeDTO::setCheckboxCharacteristicNameValuesString));
        return modelMapper.mapListsEntityToDTO(dao.findAll(), ProductCharacteristicTypeDTO.class);



    }


}
