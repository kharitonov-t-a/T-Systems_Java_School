package com.web.shop.controler.users;

import com.web.shop.constants.MessageConstants;
import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.exceptions.SaveUserException;
import com.web.shop.model.enums.UserRolesEnum;
import com.web.shop.service.front.products.ProductsCategoryServiceFront;
import com.web.shop.service.interfaces.products.ProductsCategoryService;
import com.web.shop.service.interfaces.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(/*"/signup"*/)
public class RegistrationController {

    @ModelAttribute("Title")
    public String getTitle() {
        return MessageConstants.TITLE_REGISTRATION_PAGE;
    }

    @Autowired
    UserService userService;



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
        model.addAttribute("message", MessageConstants.MESSAGE_REGISTRATION_PAGE);
        model.addAttribute("button", MessageConstants.BUTTON_REGISTRATION_PAGE);
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
//        try {
            userService.create(user, UserRolesEnum.USER);
//        }catch (SaveUserException e){
//            throw new SaveUserException();
//        }catch (Exception e){
//            throw new SaveUserException();
//        }

//InvocationTargetException


        model.addAttribute("Title", MessageConstants.TITLE_LOGIN_PAGE);
        model.addAttribute("message", String.format(
                MessageConstants.MESSAGE_LOGIN_PAGE_AFTER_REG,
                user.getFirstName()));
        return "registration/login";
    }


}