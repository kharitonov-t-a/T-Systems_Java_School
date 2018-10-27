package com.web.shop.dao;

import com.web.shop.model.User;

import java.util.List;

public interface UserDao extends GenericDao<User, Integer>{

    User findByEmail(String eMail);

    void deleteByEmail(String eMail);

//    List<User> findAllUsers();

}
