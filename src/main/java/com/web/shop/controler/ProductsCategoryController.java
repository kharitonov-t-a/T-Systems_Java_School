package com.web.shop.controler;

import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.products.ProductsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductsCategoryController {

    @Autowired
    ProductsCategoryService productsCategoryService;

    @RequestMapping(value = {"/formCategory"}, method = RequestMethod.GET)
    public String createCategory(ModelMap model) {

        List<ProductsCategoryDTO> productsCategory = productsCategoryService.findAll();

        model.addAttribute("productsCategory", productsCategory);
        model.addAttribute("productsCategoryDTO", new ProductsCategoryDTO());

        return "administration/formCategory";
    }

    @RequestMapping(value = {"/formCategory"}, method = RequestMethod.POST)
    public String createCategory(@Validated({ProductsCategoryDTO.ValidationCreate.class}) ProductsCategoryDTO productsCategoryDTO, BindingResult result, ModelMap model) throws GlobalCustomException {

        if(result.hasErrors()) {
            List<ProductsCategoryDTO> productsCategory = productsCategoryService.findAll();
            model.addAttribute("productsCategory", productsCategory);
            return "administration/formCategory";
        }

        productsCategoryService.create(productsCategoryDTO);
        return "redirect:/formCategory";
    }

    @RequestMapping(value = {"/formDeleteCategory"}, method = RequestMethod.GET)
    public String deleteCategory(ModelMap model) {

        List<ProductsCategoryDTO> productsCategory = productsCategoryService.findAll();

        model.addAttribute("productsCategory", productsCategory);
        model.addAttribute("productsCategoryDTO", new ProductsCategoryDTO());

        return "administration/formDeleteCategory";
    }

    @RequestMapping(value = {"/formDeleteCategory"}, method = RequestMethod.POST)
    public String deleteCategory(@Validated({ProductsCategoryDTO.ValidationDelete.class}) ProductsCategoryDTO productsCategoryDTO, BindingResult result, ModelMap model) throws GlobalCustomException {

        if(result.hasErrors()) {
            List<ProductsCategoryDTO> productsCategory = productsCategoryService.findAll();
            model.addAttribute("productsCategory", productsCategory);
            return "administration/formDeleteCategory";
        }

        productsCategoryService.delete(productsCategoryDTO.getId());
        return "redirect:/formDeleteCategory";
    }


}
