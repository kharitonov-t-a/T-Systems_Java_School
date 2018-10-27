package com.web.shop.service;

import com.web.shop.dao.UserProfileDao;
import com.web.shop.dto.UserProfileDTO;
import com.web.shop.model.UserProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    UserProfileDao dao;

    public UserProfileDTO findById(int id) {
        return modelMapper.map(dao.findById(id), UserProfileDTO.class) ;
    }

    public UserProfileDTO findByRole(String type){

        return modelMapper.map( dao.findByRole(type), UserProfileDTO.class) ;
    }

    public List<UserProfileDTO> findAll() {
        List<UserProfile> listUserProfile = dao.findAll();
        List<UserProfileDTO> listUserProfileDTO= new ArrayList<>();
        for (UserProfile userProfile:listUserProfile) {
            listUserProfileDTO.add(modelMapper.map( userProfile, UserProfileDTO.class));
        }
        return listUserProfileDTO;
    }
}