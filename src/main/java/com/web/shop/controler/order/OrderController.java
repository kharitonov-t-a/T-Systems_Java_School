package com.web.shop.controler.order;

import com.web.shop.dto.order.OrderDTO;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.order.OrderService;
import com.web.shop.service.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class OrderController {

    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserSecurityService userSecurityService;

    @RequestMapping(value = {"/checkoutOrder"}, method = RequestMethod.GET)
    public String checkoutOrder(ModelMap model, HttpSession httpSession) {

        OrderDTO orderSession = (OrderDTO) httpSession.getAttribute("shoppingCart");
        if (orderSession == null) {
            orderSession = new OrderDTO();
            httpSession.setAttribute("shoppingCart", orderSession);
        }

        model.addAttribute("orderSession", orderSession);
        model.addAttribute("orderDTO", orderSession);
        return "catalog/checkoutOrder";
    }

    @RequestMapping(value = {"/checkoutOrder"}, method = RequestMethod.POST)
    public String checkoutOrder(@Valid OrderDTO orderDTO, BindingResult result, ModelMap model, HttpSession httpSession) {

//        if (userSecurityService.isCurrentAuthenticationAnonymous()) {
//            return "redirect:/signup";
//        }

        OrderDTO orderSession = (OrderDTO) httpSession.getAttribute("shoppingCart");

        if (orderSession == null) {
            orderSession = new OrderDTO();
            httpSession.setAttribute("shoppingCart", orderSession);
        }

        if (result.hasErrors()) {
            model.addAttribute("orderDTO", orderSession);
            return "catalog/checkoutOrder";
        }

        if(!orderService.checkoutOrder(orderSession, orderDTO, userService.findByEmail(UserSecurityService.getPrincipal()))){
            model.addAttribute("orderSession", orderSession);
            model.addAttribute("orderDTO", orderDTO);
            return "catalog/checkoutOrder";
        }

        httpSession.setAttribute("shoppingCart", null);
        return "redirect:/orderList";
    }


    @RequestMapping(value = {"/orderList"}, method = RequestMethod.GET)
    public String orderList(ModelMap model, HttpSession httpSession) {

        model.addAttribute("orders", userService.findByEmail(UserSecurityService.getPrincipal()).getOrderList());

        return "catalog/orderList";
    }

}
