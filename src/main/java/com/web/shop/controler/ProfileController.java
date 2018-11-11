package com.web.shop.controler;

import com.web.shop.constants.MessageConstants;
import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.front.products.ProductsCategoryServiceFront;
import com.web.shop.service.interfaces.products.ProductsCategoryService;
import com.web.shop.service.interfaces.users.UserService;
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



    @ModelAttribute("Title")
    public String getTitle() {
        return MessageConstants.TITLE_PROFILE_PAGE;
    }

    @Autowired
    UserService userService;

    /**
     * This method will give profile.
     */
    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String getProfile(ModelMap model) {
        return "profile/profile";
    }


    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/userslist"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<UserDTO> users = userService.findAll();
        model.addAttribute("users", users);

        model.addAttribute("message", MessageConstants.MESSAGE_USERLIST_PAGE);

        return "profile/userslist";
    }

    @RequestMapping(value = {"/editCurrentUser"}, method = RequestMethod.GET)
    public String editCurrentUser(ModelMap model) {

        UserDTO user = userService.findByEmail(UserSecurityService.getPrincipal());


        return editInfoUser(
                getEditUserPage(user, model, false, true),
                model);

    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit-user-{id}"}, method = RequestMethod.GET)
    public String editUserByID(@PathVariable String id, ModelMap model) {

        UserDTO user = userService.findById(Integer.parseInt(id));

        //if current user is ADMIN or he is fixing his profile
//        if(!isAdminOrHimself(user, model))
//            return "accessDenied";

        return editInfoUser(
                getEditUserPage(user, model, false, true),
                model);
    }



    private String editInfoUser(String returnPage, ModelMap model) {

        model.addAttribute("message", MessageConstants.MESSAGE_EDIT_USER_PAGE);
        model.addAttribute("button", MessageConstants.BUTTON_EDIT_USER_PAGE);
        return returnPage;

    }

    /**
     * @param user
     * @param model
     * @param notEditInfo     - not show INFO part Form?
     * @param notEditPassword -  not show PASSWORD part Form?
     * @return
     */
    public String getEditUserPage(UserDTO user, ModelMap model, Boolean notEditInfo, Boolean notEditPassword) {

        model.addAttribute("userDTO", user);
        model.addAttribute("notEditInfoUser", notEditInfo);
        model.addAttribute("notEditPassword", notEditPassword);
        model.addAttribute("edit", true);
        return "registration/signup";
    }


    @RequestMapping(value = {"/edit-user-{id}"}, method = RequestMethod.POST)
    public String editUserByID(@Validated(UserDTO.ValidationInfo.class) UserDTO user, BindingResult result, ModelMap model) {

        String returnPage = getEditUserPostPage(user, result, model, false, true);

        if (returnPage.equalsIgnoreCase("done")) {

//            List<UserDTO> users = userService.findAllUsers();
//            model.addAttribute("users", users);
//
//            model.addAttribute("message", String.format(
//                    MessageConstants.MESSAGE_EDIT_USER_BY_ID_PAGE_DONE,
//                    user.getEmail()));

            return "redirect:/userslist";

        } else {
            return editInfoUser(returnPage, model);
        }

    }

    @RequestMapping(value = {"/editCurrentUser"}, method = RequestMethod.POST)
    public String editCurrentUser(@Validated(UserDTO.ValidationInfo.class) UserDTO user, BindingResult result, ModelMap model) {
        String returnPage = getEditUserPostPage(user, result, model, false, true);

        if (returnPage.equalsIgnoreCase("done")) {
            model.addAttribute("message", MessageConstants.MESSAGE_EDIT_USER_PAGE_DONE);
            model.addAttribute("button", MessageConstants.BUTTON_EDIT_USER_PAGE);
            return getEditUserPage(user, model, false, true);
        } else {
            return editInfoUser(returnPage, model);
        }
    }



    public String getEditUserPostPage(UserDTO user, BindingResult result, ModelMap model,
                                      Boolean notEditInfo, Boolean notEditPassword) {

        if (result.hasErrors()) {
            model.addAttribute("notEditInfoUser", notEditInfo);
            model.addAttribute("notEditPassword", notEditPassword);
            model.addAttribute("edit", true);
            return "registration/signup";
        }

        userService.update(user);

        return "done";
    }

    @RequestMapping(value = {"/editPassword"}, method = RequestMethod.GET)
    public String editCurrentUserPassword(ModelMap model) {

        UserDTO user = userService.findByEmail(UserSecurityService.getPrincipal());
        user.setPassword("");

        model.addAttribute("message", MessageConstants.MESSAGE_EDIT_PASSWORD_PAGE);
        model.addAttribute("button", MessageConstants.BUTTON_EDIT_PASSWORD_PAGE);

        return getEditUserPage(user, model, true, false);
    }

    @RequestMapping(value = {"/editPassword"}, method = RequestMethod.POST)
    public String editCurrentUserPassword(@Validated(UserDTO.ValidationPassword.class) UserDTO user,
                                          BindingResult result, ModelMap model) {

        String returnPage = getEditUserPostPage(user, result, model, true, false);
        model.addAttribute("button", MessageConstants.BUTTON_EDIT_PASSWORD_PAGE);

        if (returnPage.equalsIgnoreCase("done")) {

            model.addAttribute("message", MessageConstants.MESSAGE_EDIT_PASSWORD_PAGE_DONE);
            user.setPassword("");
            user.setConfirmPassword("");

            return getEditUserPage(user, model, true, false);

        } else {

            model.addAttribute("message", MessageConstants.MESSAGE_EDIT_PASSWORD_PAGE);
            return returnPage;

        }
    }

    /**
     * Delete user by ID
     */
    @RequestMapping(value = {"/delete-user-{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable String id, ModelMap model) {
        try {
            userService.delete(Integer.parseInt(id));
            return ResponseEntity.noContent().build();
        } catch (Exception /*ResourceNotFoundException */ e) {
            return ResponseEntity.notFound().build();
        }
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
//        if (!(UserSecurityService.isCurrentUserInRole(UserRolesEnum.ADMIN) ||
//                user.getEmail().equalsIgnoreCase(UserSecurityService.getPrincipal()))) {
//            model.addAttribute("message", String.format(
//                    MessageConstants.MESSAGE_EDIT_USER_ACCESS_DENIED,
//                    user.getFirstName()));
//            return false;
//        }
//        return true;
//    }
}
