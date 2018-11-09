package com.web.shop.service.interfaces.users;

import com.web.shop.dto.users.UserDTO;
import com.web.shop.dto.users.UserProfileDTO;
import com.web.shop.service.GenericService;

import java.util.List;

public interface UserProfileService extends GenericService<UserProfileDTO, Integer> {

//    UserProfileDTO findById(Integer id);
//
//    List<UserProfileDTO> findAll();

    UserProfileDTO findByRole(String role);

//    void create(UserProfileDTO userProfileDTO);
//
//    void delete(Integer id);
}