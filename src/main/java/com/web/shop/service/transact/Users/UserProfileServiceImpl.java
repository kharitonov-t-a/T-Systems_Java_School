package com.web.shop.service.transact.Users;

import com.web.shop.dao.Users.UserProfileDao;
import com.web.shop.dto.Users.UserProfileDTO;
import com.web.shop.model.Users.UserProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userProfileServiceTransact")
public class UserProfileServiceImpl implements UserProfileService{

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    UserProfileDao dao;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public UserProfileDTO findById(int id) {
        return modelMapper.map(dao.findById(id), UserProfileDTO.class) ;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public UserProfileDTO findByRole(String type){

        return modelMapper.map( dao.findByRole(type), UserProfileDTO.class) ;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<UserProfileDTO> findAll() {
        List<UserProfile> listUserProfile = dao.findAll();
        List<UserProfileDTO> listUserProfileDTO= new ArrayList<>();
        for (UserProfile userProfile:listUserProfile) {
            listUserProfileDTO.add(modelMapper.map( userProfile, UserProfileDTO.class));
        }
        return listUserProfileDTO;
    }
}