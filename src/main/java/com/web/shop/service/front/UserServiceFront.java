package com.web.shop.service.front;

import com.web.shop.dto.UserDTO;
import com.web.shop.exceptions.SaveUserException;
import com.web.shop.model.User;
import com.web.shop.model.enums.UserRoles;
import com.web.shop.service.transact.UserService;
import com.web.shop.service.transact.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceFront implements UserService {

    @Autowired
    UserService userServiceTransact;

    @Override
    public UserDTO findById(int id) {
        return userServiceTransact.findById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userServiceTransact.deleteUserById(id);
    }

    @Override
    public void saveUser(UserDTO user) throws SaveUserException {
        try {
            userServiceTransact.saveUser(user);
        }catch (Exception e){
            throw new SaveUserException();
        }
    }

    @Override
    public void updateUser(UserDTO user) {
        userServiceTransact.updateUser(user);
    }

    @Override
    public UserDTO findByEmail(String eMail) {
        return userServiceTransact.findByEmail(eMail);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userServiceTransact.findAllUsers();
    }

    @Override
    public void saveUser(UserDTO user, UserRoles role) throws SaveUserException {
        try {
            userServiceTransact.saveUser(user, role);
        }catch (Exception e){
            throw new SaveUserException();
        }
    }
}
