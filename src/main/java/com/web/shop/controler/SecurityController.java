package com.web.shop.controler;

import com.web.shop.constants.MessageConstants;
import com.web.shop.dto.user.UserDTO;
import com.web.shop.exceptions.SaveUserException;
import com.web.shop.model.enums.UserRoles;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class SecurityController {

    @Autowired
    UserSecurityService userSecurityService;

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        if (userSecurityService.isCurrentAuthenticationAnonymous()) {
            model.addAttribute("Title", MessageConstants.TITLE_LOGIN_PAGE);
            model.addAttribute("message", MessageConstants.MESSAGE_LOGIN_PAGE);
            return "registration/login";
        } else {
            return "redirect:/profile";
        }
    }

    /*
     * This method will serve as default GET handler.
     *
     */
    @RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
    public String signUp(ModelMap model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("Title", MessageConstants.TITLE_REGISTRATION_PAGE);
        model.addAttribute("userDTO", userDTO);
        return "registration/signup";
    }

    /*
     * This method will be called on form submission, handling POST request
     * It also validates the user input
     */
    @RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
    public String saveUser(@Validated({UserDTO.ValidationInfo.class, UserDTO.ValidationPassword.class}) UserDTO user, BindingResult result, ModelMap model) throws SaveUserException {

        if(result.hasErrors()) {
            return "registration/signup";
        }

        userService.create(user, UserRoles.USER);

        model.addAttribute("Title", MessageConstants.TITLE_LOGIN_PAGE);
        model.addAttribute("message", String.format(
                MessageConstants.MESSAGE_LOGIN_PAGE_AFTER_REG,
                user.getFirstName()));
        return "registration/login";
    }

//    @RequestMapping(value = "/login?logout", method = RequestMethod.GET)
//    public String logoutPage(ModelMap model) {
////        if (isCurrentAuthenticationAnonymous()) {
//        model.addAttribute("message", "Вы вышли.");
//        return "registration/login";
////        } else {
////            return "redirect:/list";
////        }
//    }
//
//
//    /**
//     * This method handles logout requests.
//     * Toggle the handlers if you are RememberMe functionality is useless in your app.
//     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            //new SecurityContextLogoutHandler().logout(request, response, auth);
//            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }
}
