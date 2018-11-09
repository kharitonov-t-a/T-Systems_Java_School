package com.web.shop.service.transact.users;

import com.web.shop.converter.UserRoleToUserProfileConverter;
import com.web.shop.dao.users.UserDao;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.dto.users.UserProfileDTO;
import com.web.shop.model.users.User;
import com.web.shop.model.enums.UserRolesEnum;
import com.web.shop.service.interfaces.users.UserService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userServiceTransact")
public class UserServiceTransactImpl extends GenericServiceTransactImpl<UserDTO, Integer, UserDao, User> implements UserService {

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
    public void create(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.create(modelMapper.map(user, User.class));
    }
//
//
//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public List<UserDTO> findAll() {
//        List<User> listUser = dao.findAll();
//        List<UserDTO> listUserDTO = new ArrayList<>();
//        for (User user : listUser) {
//            listUserDTO.add(modelMapper.map(user, UserDTO.class));
//        }
//        return listUserDTO;
//    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(UserDTO user, UserRolesEnum role) {
        Set<UserProfileDTO> usrProf = new HashSet<>();
        usrProf.add(userRoleToUserProfileConverter.convert(role.toString()));
        user.setUserProfiles(usrProf);
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
//            if(user.getUserProfiles()!=null)
//                entity.setUserProfiles(user.getUserProfiles());
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
            if (user.getSurnName() != null)
                entity.setSurnName(user.getSurnName());
            if (user.getBirthday() != null)
                entity.setBirthday(user.getBirthday());
        }
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public UserDTO findByEmail(String eMail) {
        User user = dao.findByEmail(eMail);
        if (user != null)
            return modelMapper.map(dao.findByEmail(eMail), UserDTO.class);
        else
            return null;
    }


}