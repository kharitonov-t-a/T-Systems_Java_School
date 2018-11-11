package com.web.shop.controler;

import com.web.shop.constants.MessageConstants;
import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.products.ProductsCategoryService;
import com.web.shop.service.interfaces.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {



    @Autowired
    UserService userService;

    @Autowired
    ProductsCategoryService productsCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model) {

        model.addAttribute("Title", MessageConstants.TITLE_MAIN_PAGE);
        return "index";
    }

    /**
     * This method handles Access-Denied redirect.
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {

        model.addAttribute("message", String.format(
                MessageConstants.MESSAGE_DEFAULT_ACCESS_DENIED,
                (userService.findByEmail(UserSecurityService.getPrincipal())).getFirstName()));

        model.addAttribute("Title", MessageConstants.TITLE_ACCESS_DENIED_PAGE);
        return "accessDenied";
    }

}