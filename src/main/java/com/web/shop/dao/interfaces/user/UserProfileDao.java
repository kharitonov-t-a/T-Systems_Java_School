package com.web.shop.dao.interfaces.user;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.user.UserProfile;

public interface UserProfileDao extends GenericDao<UserProfile, Integer> {

    UserProfile findByRole(String type);

//    List<UserProfile> findAll();

}