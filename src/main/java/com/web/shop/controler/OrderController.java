package com.web.shop.controler;

import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.model.users.User;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.orders.OrderService;
import com.web.shop.service.interfaces.products.ProductService;
import com.web.shop.service.interfaces.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class OrderController {

    @Autowired
    ProductService productService;
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
        if(orderSession.getOrderProducts() == null || orderSession.getOrderProducts().size() == 0)
            model.addAttribute("cartIsEmpty", true);

        model.addAttribute("orderDTO", orderSession);
        model.addAttribute("orderSession", orderSession);

        return "catalog/checkoutOrder";
    }

    @RequestMapping(value = {"/checkoutOrder"}, method = RequestMethod.POST)
    public String checkoutOrder(@Valid OrderDTO orderDTO, BindingResult result, ModelMap model, HttpSession httpSession) {

        if (userSecurityService.isCurrentAuthenticationAnonymous()) {
            return "redirect:/signup";
        }

        OrderDTO orderSession = (OrderDTO) httpSession.getAttribute("shoppingCart");
        if (result.hasErrors()) {
            if (orderSession == null) {
                orderSession = new OrderDTO();
                httpSession.setAttribute("shoppingCart", orderSession);
            }
            if(orderSession.getOrderProducts() == null || orderSession.getOrderProducts().size() == 0)
                model.addAttribute("cartIsEmpty", true);
            model.addAttribute("orderSession", orderSession);
            return "catalog/checkoutOrder";
        }

        List<ProductDTO> productDTOList = productService.checkExistInStock(orderSession, orderDTO, userService.findByEmail(UserSecurityService.getPrincipal()));

        if(productDTOList != null){
            model.addAttribute("orderSession", orderSession);
            model.addAttribute("productError", productDTOList);
            return "catalog/checkoutOrder";
        }

        httpSession.setAttribute("shoppingCart", null);
        return "redirect:/orderList";
    }


    @RequestMapping(value = {"/orderList"}, method = RequestMethod.GET)
    public String orderList(ModelMap model, HttpSession httpSession) {

        model.addAttribute("orders", userService.findByEmail(UserSecurityService.getPrincipal()).getOrders());

        return "catalog/orderList";
    }

}
