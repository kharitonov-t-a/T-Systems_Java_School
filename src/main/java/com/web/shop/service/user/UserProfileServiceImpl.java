package com.web.shop.service.user;

import com.web.shop.dao.interfaces.user.UserProfileDao;
import com.web.shop.dto.user.UserProfileDTO;
import com.web.shop.model.user.UserProfile;
import com.web.shop.service.interfaces.user.UserProfileService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userProfileService")
public class UserProfileServiceImpl extends GenericServiceImpl<UserProfileDTO, Integer, UserProfileDao, UserProfile> implements UserProfileService {

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