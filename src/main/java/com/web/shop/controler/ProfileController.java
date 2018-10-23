package com.web.shop.controler;

import com.web.shop.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProfileController {

    /**
     * This method will give profile.
     */
    @RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        return "profile/profile";
    }
}
