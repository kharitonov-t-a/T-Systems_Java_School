package com.web.shop.service;

import com.web.shop.model.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    void deleteUserById(int id);

    void saveUser(User user);

    void updateUser(User user);

    User findByEmail(String eMail);



    List<User> findAllUsers();

}