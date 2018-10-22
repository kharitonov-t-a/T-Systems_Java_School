package com.web.shop.dao;

import com.web.shop.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    void deleteById(int id);

    void saveUser(User user);

    User findByEmail(String eMail);

    void deleteByEmail(String eMail);

    List<User> findAllUsers();

}
