package com.web.shop.dao;

import com.web.shop.model.User;
import com.web.shop.model.UserProfile;

import java.util.List;

public interface UserProfileDao extends GenericDao<UserProfile, Integer>{

    UserProfile findByRole(String type);

//    List<UserProfile> findAll();

}