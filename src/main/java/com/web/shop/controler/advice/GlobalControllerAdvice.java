package com.web.shop.controler.advice;

import com.web.shop.dto.product.ProductCategoryDTO;
import com.web.shop.service.interfaces.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    ProductCategoryService productCategoryService;

    @ModelAttribute("allProductsCategoryForNavBar")
    public List<ProductCategoryDTO> getListProductsCategoryDTO(HttpSession httpSession) {
        List<ProductCategoryDTO> productCategoryDTO = (List<ProductCategoryDTO>) httpSession.getAttribute("allProductsCategoryForNavBar");
//        if(productCategoryDTO == null){
            productCategoryDTO = productCategoryService.findAll();
            if(productCategoryDTO.size() > 0)
                productCategoryDTO.remove(0);
            httpSession.setAttribute("allProductsCategoryForNavBar", productCategoryDTO);
//        }

        return productCategoryDTO;
    }
}