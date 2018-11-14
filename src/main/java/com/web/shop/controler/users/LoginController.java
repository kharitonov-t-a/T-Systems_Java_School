package com.web.shop.controler.users;

import com.web.shop.constants.MessageConstants;
import com.web.shop.security.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserSecurityService userSecurityService;

    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        if (userSecurityService.isCurrentAuthenticationAnonymous()) {
            model.addAttribute("message", MessageConstants.MESSAGE_LOGIN_PAGE);
            return "registration/login";
        } else {
            return "redirect:/profile";
        }
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
//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            //new SecurityContextLogoutHandler().logout(request, response, auth);
////            persistentTokenBasedRememberMeServices.logout(request, response, auth);
//            SecurityContextHolder.getContext().setAuthentication(null);
//        }
//        return "redirect:/login?logout";
//    }

}