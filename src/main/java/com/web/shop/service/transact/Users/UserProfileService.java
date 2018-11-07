package com.web.shop.service.transact.Users;

import com.web.shop.dto.Users.UserProfileDTO;

import java.util.List;

public interface UserProfileService {

    UserProfileDTO findById(int id);

    UserProfileDTO findByRole(String role);

    List<UserProfileDTO> findAll();

}