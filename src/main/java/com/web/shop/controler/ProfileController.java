package com.web.shop.controler;

import com.web.shop.constants.MessageConstants;
import com.web.shop.dto.user.UserDTO;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProfileController {

    /**
     * This method will give profile.
     */
    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String getProfile(ModelMap model) {
        model.addAttribute("Title", MessageConstants.TITLE_PROFILE_PAGE);
        return "profile/profile";
    }

//    /**
//     * This method will provide UserProfile list to views
//     */
//    @ModelAttribute("roles")
//    public List<UserProfile> initializeProfiles() {
//        return userProfileService.findAll();
//    }


//    private boolean isAdminOrHimself(UserDTO user, ModelMap model){
//
//        if (!(UserSecurityService.isCurrentUserInRole(UserRoles.ADMIN) ||
//                user.getEmail().equalsIgnoreCase(UserSecurityService.getPrincipal()))) {
//            model.addAttribute("message", String.format(
//                    MessageConstants.MESSAGE_EDIT_USER_ACCESS_DENIED,
//                    user.getFirstName()));
//            return false;
//        }
//        return true;
//    }
}
