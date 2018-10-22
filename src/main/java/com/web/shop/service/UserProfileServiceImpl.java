package com.web.shop.service;

import com.web.shop.dao.UserProfileDao;
import com.web.shop.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    UserProfileDao dao;

    public UserProfile findById(int id) {
        return dao.findById(id);
    }

    public UserProfile findByRole(String type){
        return dao.findByRole(type);
    }

    public List<UserProfile> findAll() {
        return dao.findAll();
    }
}