package com.web.shop.service;

import com.web.shop.dao.UserDao;
import com.web.shop.dto.UserDTO;
import com.web.shop.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao dao;

    public UserDTO findById(int id) {
        return modelMapper.map(dao.findById(id), UserDTO.class);
    }

    public void deleteUserById(int id) {
        dao.deleteById(id);
    }

    public void saveUser(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.create(modelMapper.map(user, User.class));
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(UserDTO user) {
        User entity = dao.findById(user.getId());
        if (entity != null) {
//            if(user.getUserProfiles()!=null)
//                entity.setUserProfiles(user.getUserProfiles());
            if (user.getEmail() != null)
                entity.setEmail(user.getEmail());
//            if(user.getPassword()!=null)
//                if(!user.getPassword().equals(entity.getPassword())){
//                    entity.setPassword(passwordEncoder.encode(user.getPassword()));
//                }
//            if(user.getPassword()!=null)
//                entity.setPassword(user.getPassword());
            if (user.getFirstName() != null)
                entity.setFirstName(user.getFirstName());
            if (user.getSurnName() != null)
                entity.setSurnName(user.getSurnName());
            if (user.getBirthday() != null)
                entity.setBirthday(user.getBirthday());
        }
    }

    @Override
    public UserDTO findByEmail(String eMail) {
        User user = dao.findByEmail(eMail);
        if (user != null)
            return modelMapper.map(dao.findByEmail(eMail), UserDTO.class);
        else
            return null;
    }

    public List<UserDTO> findAllUsers() {
        List<User> listUser = dao.findAll();
        List<UserDTO> listUserDTO = new ArrayList<>();
        for (User user : listUser) {
            listUserDTO.add(modelMapper.map(user, UserDTO.class));
        }
        return listUserDTO;
    }

}