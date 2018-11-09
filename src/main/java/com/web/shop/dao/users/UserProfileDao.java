package com.web.shop.dao.users;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.users.UserProfile;

public interface UserProfileDao extends GenericDao<UserProfile, Integer> {

    UserProfile findByRole(String type);

//    List<UserProfile> findAll();

}