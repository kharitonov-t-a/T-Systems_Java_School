package com.web.shop.service.front;

import com.web.shop.dto.UserProfileDTO;
import com.web.shop.service.transact.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userProfileService")
public class UserProfileServiceFront implements UserProfileService {

    @Autowired
    UserProfileService userProfileServiceTransact;

    @Override
    public UserProfileDTO findById(int id) {
        return userProfileServiceTransact.findById(id);
    }

    @Override
    public UserProfileDTO findByRole(String role) {
        return userProfileServiceTransact.findByRole(role);
    }

    @Override
    public List<UserProfileDTO> findAll() {
        return userProfileServiceTransact.findAll();
    }
}
