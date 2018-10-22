package com.web.shop.service;

import java.util.List;

import com.web.shop.dao.UserDao;
import com.web.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao dao;

    public User findById(int id) {
        return dao.findById(id);
    }

    public void deleteUserById(int id) {
        dao.deleteById(id);
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.saveUser(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setUserProfiles(user.getUserProfiles());
            entity.setEmail(user.getEmail());
            if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setPassword(user.getPassword());
            entity.setFirstName(user.getFirstName());
            entity.setSurnName(user.getSurnName());
            entity.setBirthday(user.getBirthday());
        }
    }

    @Override
    public User findByEmail(String eMail) {
        return dao.findByEmail(eMail);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

}