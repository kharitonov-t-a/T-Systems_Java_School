package com.web.shop.controler;

import com.web.shop.converter.UserRoleToUserProfileConverter;
import com.web.shop.dto.UserDTO;
import com.web.shop.dto.UserProfileDTO;
import com.web.shop.model.User;
import com.web.shop.model.UserProfile;
import com.web.shop.model.enums.UserRoles;
import com.web.shop.service.UserService;
import com.web.shop.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Controller
@RequestMapping(/*"/signup"*/)
public class RegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    UserRoleToUserProfileConverter userRoleToUserProfileConverter;

    @Autowired
    MessageSource messageSource;

    /*
     * This method will serve as default GET handler.
     *
     */
    @RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
    public String signUpPage(ModelMap model) {
        UserDTO user = new UserDTO();
        model.addAttribute("userDTO", user);
        model.addAttribute("Title", "Sign UP!");
        return "registration/signup";
    }

    /*
     * This method will be called on form submission, handling POST request
     * It also validates the user input
     */
    @RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
    public String saveUser(@Valid UserDTO user, BindingResult result, ModelMap model){

        model.addAttribute("Title", "Регистрация");
        if(result.hasErrors()) {
            return "registration/signup";
        }

        Set<UserProfileDTO> usrProf = new HashSet<>();
        usrProf.add(userRoleToUserProfileConverter.convert(UserRoles.USER.getUserRole()));
        user.setUserProfiles(usrProf);
        userService.saveUser(user);

        model.addAttribute("Title", "Вход");
        model.addAttribute("message", String.format("Вы зарегистрированы,%s</br>Теперь войдите.", user.getFirstName()));
        return "registration/login";
    }


}
