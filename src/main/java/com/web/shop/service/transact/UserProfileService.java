package com.web.shop.service.transact;

import com.web.shop.dto.UserProfileDTO;
import com.web.shop.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfileDTO findById(int id);

    UserProfileDTO findByRole(String role);

    List<UserProfileDTO> findAll();

}