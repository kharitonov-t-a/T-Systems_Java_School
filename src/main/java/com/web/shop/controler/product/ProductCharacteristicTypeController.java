package com.web.shop.controler.product;

import com.web.shop.dto.product.ProductCharacteristicTypeDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.model.enums.CharacteristicType;
import com.web.shop.service.interfaces.product.ProductCharacteristicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductCharacteristicTypeController {

    @Autowired
    ProductCharacteristicTypeService productCharacteristicTypeService;

    @RequestMapping(value = {"/formCharacteristicType"}, method = RequestMethod.GET)
    public String createCharacteristic(ModelMap model) {

        model.addAttribute("productCharacteristicTypeDTO", new ProductCharacteristicTypeDTO());
        model.addAttribute("characteristicType", CharacteristicType.values());

        return "administration/formCharacteristicType";
    }

    @RequestMapping(value = {"/formCharacteristicType"}, method = RequestMethod.POST)
    @ResponseBody
    public String createCharacteristic(@Valid ProductCharacteristicTypeDTO productCharacteristicTypeDTO,/* @RequestBody MultiValueMap<String, String> listCheckboxCharacteristicNameValue,*/ BindingResult result, ModelMap model) throws GlobalCustomException {

//        Object[] dsd = listCheckboxCharacteristicNameValue.get("listCheckboxCharacteristicNameValue[]").toArray();
        if (result.hasErrors()) {
            model.addAttribute("characteristicType", CharacteristicType.values());
            return "administration/formCharacteristicType";
        }

        productCharacteristicTypeService.create(productCharacteristicTypeDTO);
        return "redirect:/formCharacteristicType";
    }

    @RequestMapping(value = {"/formDeleteCharacteristicType"}, method = RequestMethod.GET)
    public String deleteCharacteristic(ModelMap model) {

        List<ProductCharacteristicTypeDTO> listProductCharacteristicType = productCharacteristicTypeService.findAll();

        model.addAttribute("listProductCharacteristicType", listProductCharacteristicType);
        model.addAttribute("productCharacteristicTypeDTO", new ProductCharacteristicTypeDTO());

        return "administration/formDeleteCharacteristicType";
    }

    @RequestMapping(value = {"/formDeleteCharacteristicType"}, method = RequestMethod.POST)
    public String deleteCharacteristic(@Validated({ProductCharacteristicTypeDTO.ValidationDelete.class}) ProductCharacteristicTypeDTO productCharacteristicTypeDTO, BindingResult result, ModelMap model) throws GlobalCustomException {

        if (result.hasErrors()) {
            return "administration/formDeleteCharacteristicType";
        }

        productCharacteristicTypeService.delete(productCharacteristicTypeDTO.getId());
        return "redirect:/formDeleteCharacteristicType";
    }

    @RequestMapping(value = {"/listCharacteristicType"}, method = RequestMethod.GET)
    public String listCharacteristicType(ModelMap model) {

        List<ProductCharacteristicTypeDTO> listProductCharacteristicType = productCharacteristicTypeService.findAll();

        model.addAttribute("listProductCharacteristicType", listProductCharacteristicType);

        return "administration/listCharacteristicType";
    }

}
