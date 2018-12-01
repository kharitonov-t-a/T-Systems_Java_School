package com.web.shop.controler.product;

import com.web.shop.dto.product.ProductDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.product.ProductService;
import com.web.shop.service.interfaces.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;



    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String createProduct(ModelMap model) {

        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("productCategoryList", productCategoryService.findAll());

        return "administration/productForm";
    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public String createProduct(@Valid ProductDTO productDTO, BindingResult result, ModelMap model, final RedirectAttributes redirectAttrs) throws CheckProductsCategoryException {

        if (result.hasErrors()) {
            model.addAttribute("productCategoryList", productCategoryService.findAll());
            return "administration/productForm";
        }

        productService.create(productDTO);
//        redirectAttrs.addFlashAttribute("productId", productDTO.getId());
        return "redirect:/product/list";
    }



    @RequestMapping(value = {"/{productId}"}, method = RequestMethod.GET)
    public String editProduct(@PathVariable String productId, ModelMap model) {

        model.addAttribute("productDTO", productService.findById(Integer.valueOf(productId)));
        model.addAttribute("productCategoryList", productCategoryService.findAll());

        return "administration/productForm";
    }

    @RequestMapping(value = {"/{productId}"}, method = RequestMethod.POST)
    public String editProduct(@Valid ProductDTO productDTO, BindingResult result, ModelMap model, final RedirectAttributes redirectAttrs) throws CheckProductsCategoryException {

        if (result.hasErrors()) {
            model.addAttribute("productCategoryList", productCategoryService.findAll());
            return "administration/productForm";
        }

        productService.update(productDTO);
//        redirectAttrs.addFlashAttribute("productId", productDTO.getId());
        return "redirect:/product/list";
    }


    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String productList(ModelMap model) {
        model.addAttribute("productDTOList", productService.findAll());
        return "administration/productList";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable String id, ModelMap model) {

        productService.delete(Integer.valueOf(id));

        return ResponseEntity.noContent().build();
    }

//    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
//    public String listProduct(ModelMap model) {
//        model.addAttribute("productDTOList", productService.findAll());
//        return "administration/listProductProfile";
//    }
}
