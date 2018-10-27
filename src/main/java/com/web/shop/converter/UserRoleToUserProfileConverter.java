package com.web.shop.converter;

import com.web.shop.dto.UserProfileDTO;
import com.web.shop.model.UserProfile;
import com.web.shop.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRoleToUserProfileConverter implements Converter<Integer, UserProfileDTO> {

//    static final Logger logger = LoggerFactory.getLogger(UserRoleToUserProfileConverter.class);

    @Autowired
    private UserProfileService userProfileService;

    /**
     * Gets UserProfile by Role
     */
    public UserProfileDTO convert(String role) {
        UserProfileDTO profile = userProfileService.findByRole(role);
        System.out.println("Profile : " + profile);
        return profile;
    }

    /**
     * Gets UserProfile by Id
     */
    public UserProfileDTO convert(Integer id) {
//        element.getClass();
//        Integer id = Integer.parseInt((String)element);
        UserProfileDTO profile = userProfileService.findById(id);
        System.out.println("Profile : " + profile);
        return profile;
    }

}