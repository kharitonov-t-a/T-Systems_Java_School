package com.web.shop.service.interfaces.users;

import com.web.shop.dto.users.UserDTO;
import com.web.shop.exceptions.SaveUserException;
import com.web.shop.model.enums.UserRolesEnum;
import com.web.shop.service.GenericService;

public interface UserService extends GenericService<UserDTO, Integer> {

//    UserDTO findById(Integer id);
//
//    void delete(Integer id);
//
//    void create(UserDTO user) throws SaveUserException;

    void update(UserDTO user);

//    List<UserDTO> findAll();

    UserDTO findByEmail(String eMail);

    void create(UserDTO user, UserRolesEnum role) throws SaveUserException;

}