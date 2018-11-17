package com.web.shop.service.interfaces.user;

import com.web.shop.dto.user.UserProfileDTO;
import com.web.shop.service.GenericService;

public interface UserProfileService extends GenericService<UserProfileDTO, Integer> {

//    UserProfileDTO findById(Integer id);
//
//    List<UserProfileDTO> findAll();

    UserProfileDTO findByRole(String role);

//    void create(UserProfileDTO userProfileDTO);
//
//    void delete(Integer id);
}