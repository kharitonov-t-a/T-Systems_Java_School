package com.web.shop.controler;

import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.service.front.products.ProductsCategoryServiceFront;
import com.web.shop.service.interfaces.products.ProductsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    ProductsCategoryService productsCategoryService;

    @ModelAttribute("allProductsCategoryForNavBar")
    public List<ProductsCategoryDTO> getListProductsCategoryDTO(HttpSession httpSession) {
        List<ProductsCategoryDTO> productsCategoryDTO = (List<ProductsCategoryDTO>) httpSession.getAttribute("allProductsCategoryForNavBar");
        if(productsCategoryDTO == null){
            productsCategoryDTO = productsCategoryService.findAll();
            if(productsCategoryDTO.size() > 0)
                productsCategoryDTO.remove(0);
            httpSession.setAttribute("allProductsCategoryForNavBar", productsCategoryDTO);
        }

        return productsCategoryDTO;
    }
}