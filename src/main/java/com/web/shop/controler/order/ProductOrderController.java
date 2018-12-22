package com.web.shop.controler.order;

import com.web.shop.dto.order.OrderDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.exceptions.NoProductsInStockException;
import com.web.shop.service.interfaces.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String addProductToOrder(@ModelAttribute("productId") final Integer productId, @ModelAttribute("countProduct") final Integer countProduct, ModelMap model, HttpSession httpSession) throws NoProductsInStockException {

        OrderDTO orderDTO = (OrderDTO) httpSession.getAttribute("shoppingCart");
        if (orderDTO == null) {
            orderDTO = new OrderDTO();
            httpSession.setAttribute("shoppingCart", orderDTO);
        }

        orderService.addProductToOrder(orderDTO, productId, countProduct);
        httpSession.setAttribute("shoppingCart", orderDTO);

        return "catalog/smallShoppingCart";
    }

    @RequestMapping(value = {"/changeCountProductInOrder"}, method = RequestMethod.GET)
    public ResponseEntity<Void> changeCountProductInOrder(@ModelAttribute("productId") final Integer productId, @ModelAttribute("countProduct") final Integer countProduct, ModelMap model, HttpSession httpSession) throws NoProductsInStockException {

        OrderDTO orderDTO = (OrderDTO) httpSession.getAttribute("shoppingCart");
        if (orderDTO == null) {
            orderDTO = new OrderDTO();
            httpSession.setAttribute("shoppingCart", orderDTO);
        }

        orderService.changeCountProductInOrder(orderDTO, productId, countProduct);
        httpSession.setAttribute("shoppingCart", orderDTO);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = {"/deleteProductInOrder/{productId}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProductInOrder(@PathVariable String productId, ModelMap model, HttpSession httpSession) {
        OrderDTO orderDTO = (OrderDTO) httpSession.getAttribute("shoppingCart");
        if (orderDTO == null) {
            orderDTO = new OrderDTO();
            httpSession.setAttribute("shoppingCart", orderDTO);
        }

        orderService.deleteProductInOrder(orderDTO, Integer.valueOf(productId));
        return ResponseEntity.ok().build();
    }




}
