package com.web.shop.controler.product;

import com.web.shop.dto.product.ProductCategoryDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/productCategory")
public class ProductsCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String getProductCategory(ModelMap model) {

        List<ProductCategoryDTO> productCategoryList = productCategoryService.findAll();
        model.addAttribute("productCategoryList", productCategoryList);
        model.addAttribute("productCategory", new ProductCategoryDTO());

        return "administration/productCategory";
    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public String createCategory(@Validated({ProductCategoryDTO.ValidationCreate.class}) ProductCategoryDTO productCategoryDTO, BindingResult result, ModelMap model) throws GlobalCustomException {

        if(result.hasErrors()) {
            List<ProductCategoryDTO> productCategoryList = productCategoryService.findAll();
            model.addAttribute("productCategoryList", productCategoryList);
            return "administration/productCategoryForm";
        }

        productCategoryService.create(productCategoryDTO);
        return "redirect:/productCategory";
    }

//    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
//    public String deleteCategory(ModelMap model) {
//
//        List<ProductCategoryDTO> productsCategory = productCategoryService.findAll();
//
//        model.addAttribute("productsCategory", productsCategory);
//        model.addAttribute("productsCategoryDTO", new ProductCategoryDTO());
//
//        return "administration/formDeleteCategory";
//    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable String id, ModelMap model) {
            try {
                productCategoryService.delete(Integer.valueOf(id));
                return ResponseEntity.noContent().build();
            } catch (Exception /*ResourceNotFoundException */ e) {
                return ResponseEntity.notFound().build();
            }
    }

    @RequestMapping(value = {""}, method = RequestMethod.PUT)
    public String editCategory(@Validated({ProductCategoryDTO.ValidationCreate.class}) ProductCategoryDTO productCategoryDTO, BindingResult result, ModelMap model) {

        if(result.hasErrors()) {
            List<ProductCategoryDTO> productCategoryList = productCategoryService.findAll();
            model.addAttribute("productCategoryList", productCategoryList);
            return "administration/productCategoryForm";
        }

        productCategoryService.update(productCategoryDTO);
        return "redirect:/productCategory";
    }


    @RequestMapping(value = {"/form"}, method = RequestMethod.GET)
    public String getProductCategoryForm(ModelMap model) {

        model.addAttribute("productCategory", new ProductCategoryDTO());
        model.addAttribute("buttonName", "Create");

        return "administration/productCategoryForm";
    }



}
