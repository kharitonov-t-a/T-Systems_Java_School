package com.web.shop.service;

import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.exceptions.CreateDaoException;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.exceptions.SaveUserException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface GenericService<Dto, PK extends Serializable> {

    Dto findById(PK id);

    void create(Dto dto);

    void update(Dto dto);

    void delete(PK id);

    List<Dto> findAll();
}