package com.web.shop.controler;

import com.web.shop.dto.UserDTO;
import com.web.shop.model.User;
import com.web.shop.model.enums.UserRoles;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProfileController {

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
        UserDTO user = userService.findByEmail(getPrincipal());
        return editUser(String.valueOf(user.getId()), model);
    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable String id, ModelMap model) {

        UserDTO user = userService.findById(Integer.parseInt(id));

        //if current user is ADMIN or he is fixing his profile
        if(!(isCurrentUserInRole(UserRoles.ADMIN.name()) || user.getEmail().equalsIgnoreCase(getPrincipal()))){
            model.addAttribute("userName", getPrincipal());
            return "accessDenied";
        }

        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "registration/signup";
    }


    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.POST)
    public String editUserByID(@Valid UserDTO user, BindingResult result, ModelMap model){
        String returnPage = editUser(user, result, model);
        if(returnPage.equalsIgnoreCase("done"))
            return "redirect:/userslist";
        else
            return returnPage;
    }

    @RequestMapping(value = { "/editCurrentUser" }, method = RequestMethod.POST)
    public String editCurrentUser(@Valid UserDTO user, BindingResult result, ModelMap model){
        String returnPage = editUser(user, result, model);
        if (returnPage.equalsIgnoreCase("done")){
            model.addAttribute("done", true);
            return "redirect:/editCurrentUser";
        } else {
            return returnPage;
        }
    }

//    @RequestMapping(value = { "/edit-user-{id}", "/profile" }, method = RequestMethod.POST)
    public String editUser(@Valid UserDTO user, BindingResult result, ModelMap model){

        model.addAttribute("Title", "Edit User");

        if(result.hasErrors()) {
            model.addAttribute("edit", true);
            return "registration/signup";
        }

        UserDTO oldUser = userService.findById(user.getId());

        //if current user is ADMIN or he is fixing his profile
        if(!(isCurrentUserInRole(UserRoles.ADMIN.getUserRole()) || oldUser.getEmail().equalsIgnoreCase(getPrincipal()))){
            model.addAttribute("userName", getPrincipal());
            return "accessDenied";
        }

        //if Email is changed
        if(!oldUser.getEmail().equalsIgnoreCase(user.getEmail()))
            if(userService.findByEmail(user.getEmail()) != null){
                result.addError(new ObjectError("user", "That Email already exist"));
                model.addAttribute("edit", true);
                return "registration/signup";
            }

        userService.updateUser(user);

        model.addAttribute("Title", "List users");
        return "done";
    }

    public static boolean isCurrentUserInRole(String authority) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            return authentication.getAuthorities().stream()
                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_"+authority));
        }
        return false;
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


    /**
     * Delete user by ID
     */
    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id, ModelMap model) {
        userService.deleteUserById(Integer.parseInt(id));
        return "redirect:/userslist";
    }

    //    /**
//     * This method will provide UserProfile list to views
//     */
//    @ModelAttribute("roles")
//    public List<UserProfile> initializeProfiles() {
//        return userProfileService.findAll();
//    }
}
