package com.web.shop.controler.product;

import com.web.shop.dto.product.ProductDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.product.ProductService;
import com.web.shop.service.interfaces.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService productService;



    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping(value = {"/formProduct"}, method = RequestMethod.GET)
    public String createProduct(ModelMap model) {

        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("listProductsCategoryDTO", productCategoryService.findAll());

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

    @RequestMapping(value = {"/listProduct"}, method = RequestMethod.GET)
    public String listProduct(ModelMap model) {
        List<ProductDTO> productDTOList = productService.findAll();
        model.addAttribute("productDTOList", productDTOList);
        return "administration/listProductProfile";
    }
}
