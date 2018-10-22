package com.web.shop.converter;

import com.web.shop.model.UserProfile;
import com.web.shop.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserRoleToUserProfileConverter implements Converter<Integer, UserProfile> {

    static final Logger logger = LoggerFactory.getLogger(UserRoleToUserProfileConverter.class);

    @Autowired
    private UserProfileService userProfileService;

    /**
     * Gets UserProfile by Role
     */
    public UserProfile convert(String role) {
        UserProfile profile= userProfileService.findByRole(role);
        System.out.println("Profile : "+profile);
        return profile;
    }

//    /**
//     * Gets UserProfile by Id
//     */
//    public UserProfile convert(int id) {
//        UserProfile profile= userProfileService.findById(id);
//        System.out.println("Profile : "+profile);
//        return profile;
//    }
/**
 * Gets UserProfile by Id
 */
public UserProfile convert(Integer id) {
//        element.getClass();
//        Integer id = Integer.parseInt((String)element);
        UserProfile profile= userProfileService.findById(id);
        System.out.println("Profile : "+profile);
        return profile;
        }

}