package com.web.shop.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomModelMapper<Tdto, T> extends ModelMapper {

    public List<Tdto> mapListsEntityToDTO(List<T> listFields, Class<Tdto> tdtoClass) {
         List<Tdto> listFieldsDTO = new ArrayList<>();
        for (T field : listFields) {
            listFieldsDTO.add(this.map(field, tdtoClass));
        }
        return listFieldsDTO;
    }

}
