package com.web.shop.service;

import com.web.shop.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByRole(String role);

    List<UserProfile> findAll();

}