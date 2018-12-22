package com.web.shop.controler.order;

import com.web.shop.dto.order.OrderDTO;
import com.web.shop.dto.user.UserAddressDTO;
import com.web.shop.dto.user.UserDTO;
import com.web.shop.model.enums.DeliveryType;
import com.web.shop.model.enums.OrderStatus;
import com.web.shop.model.enums.PaymentType;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.order.OrderService;
import com.web.shop.service.interfaces.user.UserAddressService;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.List;

@Controller
@RequestMapping("/")
public class OrderController {

    @Autowired
    UserService userService;
    @Autowired
    UserAddressService userAddressService;
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
        if (!userSecurityService.isCurrentAuthenticationAnonymous()) {
            List<UserAddressDTO> userAddressDTOList = userService.findByEmail(UserSecurityService.getPrincipal()).getUserAddressList();
            model.addAttribute("userAddressDTOList", userAddressDTOList);
        }
        model.addAttribute("orderSession", orderSession);
        model.addAttribute("orderDTO", orderSession);
        model.addAttribute("cartIsEmpty", orderSession.getOrderProductList().size() == 0);
        return "catalog/checkoutOrder";
    }

    @RequestMapping(value = {"/checkoutOrder"}, method = RequestMethod.POST)
    public String checkoutOrder(@Validated({UserDTO.ValidationInfo.class, UserDTO.ValidationPassword.class, UserAddressDTO.ValidationAddress.class}) OrderDTO orderDTO, BindingResult result, ModelMap model, HttpSession httpSession) {

//        if (userSecurityService.isCurrentAuthenticationAnonymous()) {
//            return "redirect:/signup";
//        }

        OrderDTO orderSession = (OrderDTO) httpSession.getAttribute("shoppingCart");
        if (!userSecurityService.isCurrentAuthenticationAnonymous()) {
            List<UserAddressDTO> userAddressDTOList = userService.findByEmail(UserSecurityService.getPrincipal()).getUserAddressList();
            model.addAttribute("userAddressDTOList", userAddressDTOList);
        }
        if (orderSession == null) {
            orderSession = new OrderDTO();
            httpSession.setAttribute("shoppingCart", orderSession);
        }

        if ((result.hasErrors() && userSecurityService.isCurrentAuthenticationAnonymous()) ||
                (result.hasErrors() && !userSecurityService.isCurrentAuthenticationAnonymous() &&
                        orderDTO.getUserAddress().getId() == null && result.getErrorCount() != 6)) {
            model.addAttribute("orderSession", orderSession);
            return "catalog/checkoutOrder";
        }

        if(orderDTO.getUser() == null && !userSecurityService.isCurrentAuthenticationAnonymous())
            orderDTO.setUser(userService.findByEmail(UserSecurityService.getPrincipal()));

        if(!orderService.checkoutOrder(orderSession, orderDTO))
        {
            model.addAttribute("orderSession", orderSession);
            model.addAttribute("orderDTO", orderDTO);
            return "catalog/checkoutOrder";
        }

        httpSession.setAttribute("shoppingCart", null);
        if(userSecurityService.isCurrentAuthenticationAnonymous())
            return "checkoutOrderSuccess";
        else
            return "redirect://profile";
    }


    @RequestMapping(value = {"/order/list"}, method = RequestMethod.GET)
    public String orderList(ModelMap model, HttpSession httpSession) {

        model.addAttribute("orderList", userService.findByEmail(UserSecurityService.getPrincipal()).getOrderList());

        return "catalog/orderList";
    }

    @RequestMapping(value = {"/order/list/all"}, method = RequestMethod.GET)
    public String orderAllList(ModelMap model, HttpSession httpSession) {

        model.addAttribute("orderList", orderService.findAll());
        model.addAttribute("orderStatusList", OrderStatus.values());

        return "catalog/orderList";
    }
    @RequestMapping(value = {"/order/changeOrderStatus/{orderId}/{orderStatus}"}, method = RequestMethod.GET)
    public ResponseEntity<Void> changeOrderStatus(@PathVariable Integer orderId, @PathVariable String orderStatus, ModelMap model, HttpSession httpSession) {

        orderService.changeOrderStatus(orderId, orderStatus);

        return ResponseEntity.ok().build();
    }

}
