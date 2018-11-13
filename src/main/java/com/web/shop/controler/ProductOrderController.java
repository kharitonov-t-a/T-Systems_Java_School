package com.web.shop.controler;

import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.orders.OrderProductDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.exceptions.NoProductsInStockException;
import com.web.shop.model.products.Product;
import com.web.shop.service.front.orders.OrderServiceFront;
import com.web.shop.service.interfaces.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

        orderService.addProductToOrder(orderDTO, Integer.valueOf(productId));
        httpSession.setAttribute("shoppingCart", orderDTO);
        return "catalog/cart";
    }

}
