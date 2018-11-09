package com.web.shop.service.transact;

import com.web.shop.converter.CustomModelMapper;
import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericServiceTransactImpl<Dto, PK extends Serializable, Dao, Entity> implements GenericService<Dto, PK> {

    @Autowired
    protected CustomModelMapper<Dto, Entity> modelMapper;

    @Autowired
    protected Dao dao;

    private Class<Dto> genericDtoType;

    private Class<Entity> genericEntityType;

    @SuppressWarnings("unchecked")
    public GenericServiceTransactImpl(){
        this.genericDtoType =(Class<Dto>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.genericEntityType =(Class<Entity>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[3];
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Dto findById(PK id) {
        return modelMapper.map(((GenericDaoImpl) dao).findById(id), genericDtoType);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(Dto productCharacteristicDTO) {
        ((GenericDaoImpl) dao).create(modelMapper.map(productCharacteristicDTO, genericEntityType));
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(PK id) {
        ((GenericDaoImpl) dao).deleteById(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Dto> findAll() {
        return modelMapper.mapListsEntityToDTO(((GenericDaoImpl) dao).findAll(), genericDtoType);
    }
}
