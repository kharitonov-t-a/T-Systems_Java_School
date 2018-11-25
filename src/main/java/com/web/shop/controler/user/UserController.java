package com.web.shop.controler.user;

import com.web.shop.constants.MessageConstants;
import com.web.shop.dto.user.UserDTO;
import com.web.shop.exceptions.SaveUserException;
import com.web.shop.model.enums.UserRoles;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        model.addAttribute("userDTOList", userService.findAll());
        return "user/userList";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String createUser(ModelMap model) {

        model.addAttribute("userDTO", new UserDTO());
        return "registration/signup";

    }

    @RequestMapping(value = { "/create" }, method = RequestMethod.POST)
    public String createUser(@Validated({UserDTO.ValidationInfo.class, UserDTO.ValidationPassword.class}) UserDTO user, BindingResult result, ModelMap model) throws SaveUserException {

        if(result.hasErrors()) {
            return "registration/signup";
        }

        userService.create(user, UserRoles.USER);
        return "redirect:/user/list";
    }

    /**
     * Edit Current User
     * @param model
     * @return
     */
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String editUser(ModelMap model) {

        model.addAttribute("userDTO", userService.findByEmail(UserSecurityService.getPrincipal()));
        return "user/info";

    }

    /**
     * Edit User By ID
     */
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String id, ModelMap model) {

        model.addAttribute("userDTO", userService.findById(Integer.parseInt(id)));
        return "user/info";

    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public String editCurrentUser(@Validated(UserDTO.ValidationInfo.class) UserDTO userDTO, BindingResult result, ModelMap model) {

        if(result.hasErrors()) {
            return "user/info";
        }

        userService.update(userDTO);
        return "user/info";

    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public String editUserById(@Validated(UserDTO.ValidationInfo.class) UserDTO userDTO, BindingResult result, ModelMap model) {

        if(result.hasErrors()) {
            return "user/info";
        }

        userService.update(userDTO);
        return "redirect:/user/list";

    }

    @RequestMapping(value = {"/password"}, method = RequestMethod.GET)
    public String editCurrentUserPassword(ModelMap model) {

        UserDTO userDTO = userService.findByEmail(UserSecurityService.getPrincipal());
        userDTO.setPassword("");
        model.addAttribute("userDTO", userDTO);
        return "user/password";

    }

    @RequestMapping(value = {"/password"}, method = RequestMethod.POST)
    public String editCurrentUserPassword(@Validated(UserDTO.ValidationPassword.class) UserDTO userDTO,
                                          BindingResult result, ModelMap model) {

        if(result.hasErrors()) {
            return "user/password";
        }

        userService.update(userDTO);
        userDTO.setPassword("");
        userDTO.setConfirmPassword("");
        model.addAttribute("userDTO", userDTO);
        return "user/password";

    }

    /**
     * Delete Current User
     */
    @RequestMapping(value = {""}, method = RequestMethod.DELETE)
    public String deleteUser(ModelMap model) {
//        try {
            userService.delete(userService.findByEmail(UserSecurityService.getPrincipal()).getId());

            return "redirect:/logout";
//        } catch (Exception /*ResourceNotFoundException */ e) {
//            return ResponseEntity.notFound().build();
//        }
    }
    /**
     * Delete user by ID
     */
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable String id, ModelMap model) {
//        try {
            userService.delete(Integer.parseInt(id));
            return ResponseEntity.noContent().build();
//        } catch (Exception /*ResourceNotFoundException */ e) {
//            return ResponseEntity.notFound().build();
//        }
    }

}
