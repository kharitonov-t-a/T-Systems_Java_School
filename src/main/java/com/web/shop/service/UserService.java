package com.web.shop.service;

import com.web.shop.dto.UserDTO;
import com.web.shop.model.User;

import java.util.List;

public interface UserService {

    UserDTO findById(int id);

    void deleteUserById(int id);

    void saveUser(UserDTO user);

    void updateUser(UserDTO user);

    UserDTO findByEmail(String eMail);



    List<UserDTO> findAllUsers();

}