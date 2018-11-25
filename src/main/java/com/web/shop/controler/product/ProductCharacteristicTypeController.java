package com.web.shop.controler.product;

import com.web.shop.dto.product.ProductCharacteristicTypeDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.model.enums.CharacteristicType;
import com.web.shop.service.interfaces.product.ProductCategoryService;
import com.web.shop.service.interfaces.product.ProductCharacteristicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product/characteristic/type")
public class ProductCharacteristicTypeController {

    @Autowired
    ProductCharacteristicTypeService productCharacteristicTypeService;

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String getCreateCharacteristicForm(ModelMap model) {

        model.addAttribute("productCharacteristicTypeDTO", new ProductCharacteristicTypeDTO());
        model.addAttribute("productCharacteristicTypeValues", CharacteristicType.values());
        model.addAttribute("productCategoryList", productCategoryService.findAll());
        model.addAttribute("modalTitle", "Create product characteristic type");

        return "administration/productCharacteristicTypeForm";
    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public String createCharacteristic(@Valid ProductCharacteristicTypeDTO productCharacteristicTypeDTO, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "administration/productCharacteristicTypeForm";
        }

        productCharacteristicTypeService.create(productCharacteristicTypeDTO);
        return "redirect:/product/characteristic/type/list";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getEditCharacteristicForm(@PathVariable String id, ModelMap model) {

        model.addAttribute("productCharacteristicTypeDTO", productCharacteristicTypeService.findById(Integer.valueOf(id)));
        model.addAttribute("productCharacteristicTypeValues", CharacteristicType.values());
        model.addAttribute("productCategoryList", productCategoryService.findAll());
        model.addAttribute("modalTitle", "Change product characteristic type");

        return "administration/productCharacteristicTypeForm";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public String editCharacteristic(@Valid ProductCharacteristicTypeDTO productCharacteristicTypeDTO, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "administration/productCharacteristicTypeForm";
        }

        productCharacteristicTypeService.update(productCharacteristicTypeDTO);
        return characteristicTypeList(model);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCharacteristic(@PathVariable String id, ModelMap model) {

        productCharacteristicTypeService.delete(Integer.valueOf(id));

        return ResponseEntity.noContent().build();
    }
//
//    @RequestMapping(value = {"/formDeleteCharacteristicType"}, method = RequestMethod.POST)
//    public String deleteCharacteristic(@Validated({ProductCharacteristicTypeDTO.ValidationDelete.class}) ProductCharacteristicTypeDTO productCharacteristicTypeDTO, BindingResult result, ModelMap model) throws GlobalCustomException {
//
//        if (result.hasErrors()) {
//            return "administration/formDeleteCharacteristicType";
//        }
//
//        productCharacteristicTypeService.delete(productCharacteristicTypeDTO.getId());
//        return "redirect:/formDeleteCharacteristicType";
//    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String characteristicTypeList(ModelMap model) {

        List<ProductCharacteristicTypeDTO> productCharacteristicTypeDTOList = productCharacteristicTypeService.findAll();

        model.addAttribute("productCharacteristicTypeDTOList", productCharacteristicTypeDTOList);

        return "administration/productCharacteristicTypeList";
    }

}
