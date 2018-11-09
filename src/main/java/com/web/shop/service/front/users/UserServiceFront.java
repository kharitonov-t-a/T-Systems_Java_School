package com.web.shop.service.front.users;

import com.web.shop.dto.users.UserDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.exceptions.SaveUserException;
import com.web.shop.model.enums.UserRolesEnum;
import com.web.shop.service.interfaces.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceFront implements UserService {

    @Autowired
    UserService userServiceTransact;

    public UserDTO findById(Integer id) {
        return userServiceTransact.findById(id);
    }

    public void create(UserDTO user) throws SaveUserException {
        try {
            userServiceTransact.create(user);
        }catch (Exception e){
            throw new SaveUserException();
        }
    }

    public void delete(Integer id) throws GlobalCustomException {
        userServiceTransact.delete(id);
    }

    public void update(UserDTO user) {
        userServiceTransact.update(user);
    }

    public UserDTO findByEmail(String eMail) {
        return userServiceTransact.findByEmail(eMail);
    }

    public List<UserDTO> findAll() {
        return userServiceTransact.findAll();
    }

    public void create(UserDTO user, UserRolesEnum role) throws SaveUserException {
        try {
            userServiceTransact.create(user, role);
        }catch (Exception e){
            throw new SaveUserException();
        }
    }
}
