package com.web.shop.service.transact.users;

import com.web.shop.dao.users.UserProfileDao;
import com.web.shop.dto.users.UserProfileDTO;
import com.web.shop.model.users.UserProfile;
import com.web.shop.service.interfaces.users.UserProfileService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userProfileServiceTransact")
public class UserProfileServiceTransactImpl extends GenericServiceTransactImpl<UserProfileDTO, Integer, UserProfileDao, UserProfile> implements UserProfileService {

//    @Autowired
//    CustomModelMapper<UserProfileDTO, UserProfile> modelMapper;
//
//    @Autowired
//    UserProfileDao dao;
//
//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public UserProfileDTO findById(int id) {
//        return modelMapper.map(dao.findById(id), UserProfileDTO.class) ;
//    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public UserProfileDTO findByRole(String type){

        return modelMapper.map( dao.findByRole(type), UserProfileDTO.class) ;
    }

    //    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public List<UserProfileDTO> findAll() {
//        List<UserProfile> listUserProfile = dao.findAll();
//        List<UserProfileDTO> listUserProfileDTO= new ArrayList<>();
//        for (UserProfile userProfile:listUserProfile) {
//            listUserProfileDTO.add(modelMapper.map( userProfile, UserProfileDTO.class));
//        }
//        return listUserProfileDTO;
//    }
}