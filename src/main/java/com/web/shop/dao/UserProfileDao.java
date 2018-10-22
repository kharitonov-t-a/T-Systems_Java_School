package com.web.shop.dao;

import com.web.shop.model.UserProfile;

import java.util.List;

public interface UserProfileDao {

    List<UserProfile> findAll();

    UserProfile findByRole(String type);

    UserProfile findById(int id);
}