package com.web.shop.service;

import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.exceptions.SaveUserException;

import java.io.Serializable;
import java.util.List;

public interface GenericService<Dto, PK extends Serializable> {

    Dto findById(PK id);

    void create(Dto dto) throws GlobalCustomException;

    void delete(PK id) throws GlobalCustomException;

    List<Dto> findAll();
}