package com.web.shop.controler.product;

import com.web.shop.dto.product.ProductCategoryDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.exceptions.CreateDaoException;
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

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String getProductCategory(ModelMap model) {

        List<ProductCategoryDTO> productCategoryList = productCategoryService.findAll();
        model.addAttribute("productCategoryList", productCategoryList);
        model.addAttribute("productCategory", new ProductCategoryDTO());

        return "administration/productCategory";
    }


    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String getProductCategoryFormCreate(ModelMap model) {
        model.addAttribute("productCategoryDTO", new ProductCategoryDTO());

        return "administration/productCategoryForm";
    }


    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public String createCategory(@Valid ProductCategoryDTO productCategory, BindingResult result, ModelMap model) throws CheckProductsCategoryException {

        if(result.hasErrors()) {
            return "administration/productCategoryForm";
        }

        productCategoryService.createNode(productCategory);
        return "redirect:/productCategory";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getProductCategoryFormEdit(@PathVariable Integer id, ModelMap model) {

        model.addAttribute("productCategoryDTO", productCategoryService.findById(id));

        return "administration/productCategoryForm";
    }


    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public String editCategory(@PathVariable Integer id, @Valid ProductCategoryDTO productCategory, BindingResult result, ModelMap model) throws CheckProductsCategoryException {

        if(result.hasErrors()) {
            return "administration/productCategoryForm";
        }

        productCategoryService.updateNode(productCategory);
        return "redirect:/productCategory";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable String id, ModelMap model) throws CheckProductsCategoryException {
        productCategoryService.deleteNode(Integer.valueOf(id));
        return ResponseEntity.noContent().build();
    }


}
