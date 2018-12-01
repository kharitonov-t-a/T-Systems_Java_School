package com.web.shop.converter;

import com.web.shop.dto.product.ProductCharacteristicTypeDTO;
import com.web.shop.model.product.ProductCharacteristicType;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomModelMapper<Tdto, T> extends ModelMapper {


    public CustomModelMapper() {
        super();
        this.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.typeMap(ProductCharacteristicType.class, ProductCharacteristicTypeDTO.class)
                .addMappings(m -> m.map(src -> src.getProductCategory(), ProductCharacteristicTypeDTO::setProductCategory));
    }

    public List<Tdto> mapListsEntityToDTO(List<T> listFields, Class<Tdto> tdtoClass) {
         List<Tdto> listFieldsDTO = new ArrayList<>();
        for (T field : listFields) {
            listFieldsDTO.add(this.map(field, tdtoClass));
        }
        return listFieldsDTO;
    }

}
