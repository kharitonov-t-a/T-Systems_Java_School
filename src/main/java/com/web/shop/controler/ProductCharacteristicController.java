package com.web.shop.controler;

import com.web.shop.dto.products.ProductCharacteristicDTO;
import com.web.shop.dto.products.ProductCharacteristicTypeDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.model.enums.CharacteristicTypeEnum;
import com.web.shop.model.products.CheckboxCharacteristicNameValues;
import com.web.shop.model.products.ProductCharacteristic;
import com.web.shop.service.interfaces.products.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class ProductCharacteristicController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductCharacteristicTypeService productCharacteristicTypeService;

    @Autowired
    ProductCharacteristicService productCharacteristicService;


    @RequestMapping(value = {"/formProductCharacteristic"}, method = RequestMethod.GET)
    public String getStartFormProductCharacteristic(@ModelAttribute("productId") final Integer productId, ModelMap model) {

        model.addAttribute("listProductCharacteristicTypeDTO", productCharacteristicTypeService.findAll());
        model.addAttribute("idProduct", productId);
        ProductDTO productDTO = productService.findById(productId);
        model.addAttribute("listProductCharacteristic", productDTO.getProductCharacteristic());

        return "administration/formProductCharacteristic";
    }

    @RequestMapping(value = {"/getFormProductCharacteristic"}, method = RequestMethod.GET)
    public String getFormProductCharacteristic(@RequestParam("id") Integer id, @RequestParam("productId") Integer productId, ModelMap model) {

        ProductCharacteristicTypeDTO productCharacteristicTypeDTO = productCharacteristicTypeService.findById(id);
//        if(productCharacteristicTypeDTO.getCharacteristicType().equals(CharacteristicTypeEnum.CHECKBOX))
//            model.addAttribute("CheckboxCharacteristicNameValues", productCharacte+-risticTypeDTO.getCheckboxCharacteristicNameValuesString());
        model.addAttribute("productCharacteristicTypeDTO", productCharacteristicTypeDTO);
        model.addAttribute("productCharacteristicDTO", new ProductCharacteristicDTO());
        model.addAttribute("productId", productId);

        return "administration/characteristicForm";
    }

    @RequestMapping(value = {"/getFormProductCharacteristic"}, method = RequestMethod.POST)
    public String createProductCharacteristic(@Valid ProductCharacteristicDTO productCharacteristicDTO, BindingResult result,ModelMap model, final RedirectAttributes redirectAttrs) throws GlobalCustomException {

        if (result.hasErrors()) {
            return "administration/characteristicForm";
        }

        productCharacteristicService.create(productCharacteristicDTO);

        redirectAttrs.addFlashAttribute("productId", productCharacteristicDTO.getProductId());

        return "redirect:/formProductCharacteristic";
    }


}
