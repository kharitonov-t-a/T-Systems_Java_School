package com.web.shop.service.transact;

import com.web.shop.dto.UserDTO;
import com.web.shop.exceptions.SaveUserException;
import com.web.shop.model.enums.UserRoles;

import java.util.List;

public interface UserService {

    UserDTO findById(int id);

    void deleteUserById(int id);

    void saveUser(UserDTO user) throws SaveUserException;

    void updateUser(UserDTO user);

    UserDTO findByEmail(String eMail);

    List<UserDTO> findAllUsers();

    // ????????????????????????????????????

    void saveUser(UserDTO user, UserRoles role) throws SaveUserException;


}