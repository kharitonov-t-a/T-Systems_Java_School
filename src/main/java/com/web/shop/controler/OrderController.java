package com.web.shop.controler;

import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.products.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class OrderController {

    @RequestMapping(value = {"/checkoutOrder"}, method = RequestMethod.GET)
    public String checkoutOrder(ModelMap model, HttpSession httpSession) {

        OrderDTO orderDTO = (OrderDTO) httpSession.getAttribute("shoppingCart");
        if (orderDTO == null) {
            orderDTO = new OrderDTO();
            httpSession.setAttribute("order", orderDTO);
        }

        model.addAttribute("orderDTO", orderDTO);

        return "catalog/checkoutOrder";
    }

}
