package com.web.shop.controler.product;

import com.web.shop.dto.product.ProductCharacteristicDTO;
import com.web.shop.dto.product.ProductCharacteristicTypeDTO;
import com.web.shop.dto.product.ProductDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/product/characteristic")
public class ProductCharacteristicController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductCharacteristicTypeService productCharacteristicTypeService;


    @RequestMapping(value = {"/{catalogId}/{productId}"}, method = RequestMethod.GET)
    public String getStartFormProductCharacteristic(@PathVariable String catalogId, @PathVariable String productId, ModelMap model) {

        model.addAttribute("productCharacteristicTypeDTOList", productCharacteristicTypeService.findByCatalogId(Integer.valueOf(catalogId)));
        model.addAttribute("productDTO", productService.findById(Integer.valueOf(productId)));

        return "administration/productCharacteristicForm";
    }

    @RequestMapping(value = {"/{catalogId}"}, method = RequestMethod.GET)
    public String getStartFormProductCharacteristic(@PathVariable String catalogId, ModelMap model) {

        model.addAttribute("productCharacteristicTypeDTOList", productCharacteristicTypeService.findByCatalogId(Integer.valueOf(catalogId)));
        model.addAttribute("productDTO", new ProductDTO());

        return "administration/productCharacteristicForm";
    }

    @RequestMapping(value = {"/retry"}, method = RequestMethod.POST)
    public String getStartFormProductCharacteristicRetry(@Valid ProductDTO productDTO, BindingResult result, ModelMap model) {

        model.addAttribute("productCharacteristicTypeDTOList", productCharacteristicTypeService.findByCatalogId(productDTO.getProductCategory().getId()));
        return "administration/productCharacteristicForm";
    }



//    @RequestMapping(value = {"/getFormProductCharacteristic"}, method = RequestMethod.GET)
//    public String getFormProductCharacteristic(@RequestParam("id") Integer id, @RequestParam("productId") Integer productId, ModelMap model) {
//
//        ProductCharacteristicTypeDTO productCharacteristicTypeDTO = productCharacteristicTypeService.findById(id);
////        if(productCharacteristicTypeDTO.getProductCharacteristicType().equals(ProductCharacteristicType.CHECKBOX))
////            model.addAttribute("ProductCharacteristicCheckboxField", productCharacte+-risticTypeDTO.getCheckboxCharacteristicNameValuesString());
//        model.addAttribute("productCharacteristicTypeDTO", productCharacteristicTypeDTO);
//        model.addAttribute("productCharacteristicDTO", new ProductCharacteristicDTO());
//        model.addAttribute("productId", productId);
//
//        return "administration/productCharacteristicForm";
//    }
//
//    @RequestMapping(value = {"/getFormProductCharacteristic"}, method = RequestMethod.POST)
//    public String createProductCharacteristic(@Valid ProductCharacteristicDTO productCharacteristicDTO, BindingResult result, ModelMap model, final RedirectAttributes redirectAttrs) throws GlobalCustomException {
//
//        if (result.hasErrors()) {
//            return "administration/productCharacteristicForm";
//        }
//
//        productCharacteristicService.create(productCharacteristicDTO);
//
//        redirectAttrs.addFlashAttribute("productId", productCharacteristicDTO.getProduct().getId());
//
//        return "redirect:/formProductCharacteristic";
//    }


}
