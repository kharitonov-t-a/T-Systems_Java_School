package com.web.shop.controler;

import com.web.shop.dto.Products.ProductsCategoryDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.service.transact.Products.ProductsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

//        model.addAttribute("message", MessageConstants.MESSAGE_USERLIST_PAGE);

        return "administration/formCategory";
    }

    @RequestMapping(value = {"/formCategory"}, method = RequestMethod.POST)
    public String createCategory(@Validated({ProductsCategoryDTO.ValidationCreate.class}) ProductsCategoryDTO productsCategoryDTO, BindingResult result, ModelMap model) throws CheckProductsCategoryException {

        if(result.hasErrors()) {
            List<ProductsCategoryDTO> productsCategory = productsCategoryService.findAll();
            model.addAttribute("productsCategory", productsCategory);
            return "administration/formCategory";
        }

        productsCategoryService.saveNewProductsCategory(productsCategoryDTO);
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
    public String deleteCategory(@Validated({ProductsCategoryDTO.ValidationDelete.class}) ProductsCategoryDTO productsCategoryDTO, BindingResult result, ModelMap model) throws CheckProductsCategoryException {

        if(result.hasErrors()) {
            List<ProductsCategoryDTO> productsCategory = productsCategoryService.findAll();
            model.addAttribute("productsCategory", productsCategory);
            return "administration/formDeleteCategory";
        }

        productsCategoryService.deleteProductsCategory(productsCategoryDTO.getId());
        return "redirect:/formDeleteCategory";
    }


}
