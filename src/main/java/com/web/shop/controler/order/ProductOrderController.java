package com.web.shop.controler.order;

import com.web.shop.dto.order.OrderDTO;
import com.web.shop.exceptions.NoProductsInStockException;
import com.web.shop.service.interfaces.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class ProductOrderController {

    @Autowired
    OrderService orderService;

    // translit name product instead id
    @RequestMapping(value = {"/addProductToOrder"}, method = RequestMethod.GET)
    public String addProductToOrder(@ModelAttribute("productId") final Integer productId, ModelMap model, HttpSession httpSession) throws NoProductsInStockException {

        OrderDTO orderDTO = (OrderDTO) httpSession.getAttribute("shoppingCart");
        if (orderDTO == null) {
            orderDTO = new OrderDTO();
            httpSession.setAttribute("order", orderDTO);
        }

        orderService.addProductToOrder(orderDTO, productId);
        httpSession.setAttribute("shoppingCart", orderDTO);

        return "catalog/cart";
    }

}
