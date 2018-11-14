package com.web.shop.controler.products;

import com.web.shop.dto.products.ProductDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.model.enums.CharacteristicTypeEnum;
import com.web.shop.model.products.ProductCharacteristicType;
import com.web.shop.service.interfaces.products.ProductCharacteristicTypeService;
import com.web.shop.service.interfaces.products.ProductService;
import com.web.shop.service.interfaces.products.ProductsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService productService;



    @Autowired
    ProductsCategoryService productsCategoryService;

    @RequestMapping(value = {"/formProduct"}, method = RequestMethod.GET)
    public String createProduct(ModelMap model) {

        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("listProductsCategoryDTO", productsCategoryService.findAll());

        return "administration/formProduct";
    }

    @RequestMapping(value = {"/formProduct"}, method = RequestMethod.POST)
    public String createProduct(@Valid ProductDTO productDTO, BindingResult result, ModelMap model, final RedirectAttributes redirectAttrs) throws GlobalCustomException {

        if (result.hasErrors()) {
            return "administration/formProduct";
        }

        productService.create(productDTO);
        redirectAttrs.addFlashAttribute("productId", productDTO.getId());
        return "redirect:/formProductCharacteristic";
    }
}
