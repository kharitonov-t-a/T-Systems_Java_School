package com.web.shop.controler;

import com.web.shop.Constants.MessageConstants;
import com.web.shop.dto.UserDTO;
import com.web.shop.model.User;
import com.web.shop.model.enums.UserRoles;
import com.web.shop.security.CustomUserDetailsService;
import com.web.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProfileController {

    @ModelAttribute("Title")
    public String getTitle() {
        return MessageConstants.TITLE_PROFILE_PAGE;
    }

    @Autowired
    UserService userService;

    /**
     * This method will give profile.
     */
    @RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
    public String getProfile(ModelMap model) {
        return "profile/profile";
    }



    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = { "/userslist" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<UserDTO> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "profile/userslist";
    }

    @RequestMapping(value = { "/editCurrentUser" }, method = RequestMethod.GET)
    public String editCurrentUser(ModelMap model){
        UserDTO user = userService.findByEmail(CustomUserDetailsService.getPrincipal());
        return getEditUserPage(user, model);
    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.GET)
    public String editUserByID(@PathVariable String id, ModelMap model) {

        UserDTO user = userService.findById(Integer.parseInt(id));

        //if current user is ADMIN or he is fixing his profile
        if(!(CustomUserDetailsService.isCurrentUserInRole(UserRoles.ADMIN) ||
                user.getEmail().equalsIgnoreCase(CustomUserDetailsService.getPrincipal()))){

            model.addAttribute("message", String.format(
                    MessageConstants.MESSAGE_EDIT_USER_ACCESS_DENIED,
                    user.getFirstName()));
            return "accessDenied";

        }

        return getEditUserPage(user, model);

    }

    public String getEditUserPage(UserDTO user, ModelMap model){
        model.addAttribute("userDTO", user);
        model.addAttribute("edit", true);
        return "registration/signup";
    }


    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.POST)
    public String editUserByID(@Valid UserDTO user, BindingResult result, ModelMap model){
        String returnPage = getEditUserPostPage(user, result, model);
        if(returnPage.equalsIgnoreCase("done"))
            return "profile/userslist";
        else
            return returnPage;
    }

    @RequestMapping(value = { "/editCurrentUser" }, method = RequestMethod.POST)
    public String editCurrentUser(@Valid UserDTO user, BindingResult result, ModelMap model){
        String returnPage = getEditUserPostPage(user, result, model);
        if (returnPage.equalsIgnoreCase("done")){
            model.addAttribute("done", true);
            return "redirect:/editCurrentUser";
        } else {
            return returnPage;
        }
    }

    public String getEditUserPostPage(@Valid UserDTO user, BindingResult result, ModelMap model){

        if(result.hasErrors()) {
            model.addAttribute("edit", true);
            return "registration/signup";
        }

        UserDTO oldUser = userService.findById(user.getId());

        //if current user is ADMIN or he is fixing his profile
        if(!(CustomUserDetailsService.isCurrentUserInRole(UserRoles.ADMIN) ||
                oldUser.getEmail().equalsIgnoreCase(CustomUserDetailsService.getPrincipal()))){
            model.addAttribute("message", String.format(
                    MessageConstants.MESSAGE_EDIT_USER_ACCESS_DENIED,
                    oldUser.getFirstName()));
            return "accessDenied";
        }

        //if Email is changed
        if(!oldUser.getEmail().equalsIgnoreCase(user.getEmail()))
            if(userService.findByEmail(user.getEmail()) != null){
                model.addAttribute("edit", true);
                return "registration/signup";
            }

        userService.updateUser(user);

        return "done";
    }



    /**
     * Delete user by ID
     */
    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id, ModelMap model) {
        userService.deleteUserById(Integer.parseInt(id));
        return "profile/userslist";
    }

    //    /**
//     * This method will provide UserProfile list to views
//     */
//    @ModelAttribute("roles")
//    public List<UserProfile> initializeProfiles() {
//        return userProfileService.findAll();
//    }
}
