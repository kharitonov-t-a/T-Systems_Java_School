package com.web.shop.dao.Users;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.Users.UserProfile;

public interface UserProfileDao extends GenericDao<UserProfile, Integer> {

    UserProfile findByRole(String type);

//    List<UserProfile> findAll();

}