package com.web.shop.service.user;

import com.web.shop.converter.UserRoleToUserProfileConverter;
import com.web.shop.dao.user.UserDao;
import com.web.shop.dto.user.UserDTO;
import com.web.shop.dto.user.UserProfileDTO;
import com.web.shop.exceptions.SaveUserException;
import com.web.shop.model.enums.UserRoles;
import com.web.shop.model.user.User;
import com.web.shop.service.interfaces.user.UserService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<UserDTO, Integer, UserDao, User> implements UserService {

//    @Autowired
//    CustomModelMapper<UserDTO, User> modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private UserDao dao;

    @Autowired
    UserRoleToUserProfileConverter userRoleToUserProfileConverter;

//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public UserDTO findById(int id) {
//        return modelMapper.map(dao.findById(id), UserDTO.class);
//    }
//
//    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
//    public void delete(int id) {
//        dao.deleteById(id);
//    }
//
//
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(UserDTO user)   {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            dao.create(modelMapper.map(user, User.class));
        }catch (Exception e){
//            throw new SaveUserException();
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(UserDTO user, UserRoles role) throws SaveUserException {
        Set<UserProfileDTO> usrProf = new HashSet<>();
        usrProf.add(userRoleToUserProfileConverter.convert(role.toString()));
        user.setUserProfileSet(usrProf);
        create(user);
    }


    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(UserDTO user) {
        User entity = dao.findById(user.getId());
        if (entity != null) {
//            if(user.getUserProfileSet()!=null)
//                entity.setUserProfileSet(user.getUserProfileSet());
            if (user.getEmail() != null)
                entity.setEmail(user.getEmail());
            if(user.getPassword()!=null && user.getConfirmPassword()!=null)
                if(!(passwordEncoder.encode(user.getPassword())).equalsIgnoreCase(entity.getPassword())){
                    entity.setPassword(passwordEncoder.encode(user.getPassword()));
                }
//            if(user.getPassword()!=null)
//                entity.setPassword(user.getPassword());
            if (user.getFirstName() != null)
                entity.setFirstName(user.getFirstName());
            if (user.getLastName() != null)
                entity.setLastName(user.getLastName());
            if (user.getBirthday() != null)
                entity.setBirthday(user.getBirthday());
        }
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public UserDTO findByEmail(String eMail) {
        User user = dao.findByEmail(eMail);
        if (user != null)
            return modelMapper.map(user, UserDTO.class);
        else
            return null;
    }


}