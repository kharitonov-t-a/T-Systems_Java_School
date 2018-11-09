package com.web.shop.service.front.users;

import com.web.shop.dto.users.UserProfileDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.exceptions.SaveUserException;
import com.web.shop.service.interfaces.users.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userProfileService")
public class UserProfileServiceFront implements UserProfileService {

    @Autowired
    UserProfileService userProfileServiceTransact;

    public UserProfileDTO findById(Integer id) {
        return userProfileServiceTransact.findById(id);
    }

    public void create(UserProfileDTO userProfileDTO) throws GlobalCustomException {
        userProfileServiceTransact.create(userProfileDTO);
    }

    public void delete(Integer id) throws GlobalCustomException {
        userProfileServiceTransact.delete(id);
    }

    public UserProfileDTO findByRole(String role) {
        return userProfileServiceTransact.findByRole(role);
    }

    public List<UserProfileDTO> findAll() {
        return userProfileServiceTransact.findAll();
    }
}
