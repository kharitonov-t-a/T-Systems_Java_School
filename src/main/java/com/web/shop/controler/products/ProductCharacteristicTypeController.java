package com.web.shop.controler.products;

import com.web.shop.dto.products.ProductCharacteristicTypeDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.model.enums.CharacteristicTypeEnum;
import com.web.shop.service.interfaces.products.ProductCharacteristicTypeService;
import com.web.shop.service.interfaces.users.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ProductCharacteristicTypeController {

    @Autowired
    ProductCharacteristicTypeService productCharacteristicTypeService;

    @RequestMapping(value = {"/formCharacteristicType"}, method = RequestMethod.GET)
    public String createCharacteristic(ModelMap model) {

        model.addAttribute("productCharacteristicTypeDTO", new ProductCharacteristicTypeDTO());
        model.addAttribute("characteristicType", CharacteristicTypeEnum.values());

        return "administration/formCharacteristicType";
    }

    @RequestMapping(value = {"/formCharacteristicType"}, method = RequestMethod.POST)
    @ResponseBody
    public String createCharacteristic(@Valid ProductCharacteristicTypeDTO productCharacteristicTypeDTO,/* @RequestBody MultiValueMap<String, String> listCheckboxCharacteristicNameValue,*/ BindingResult result, ModelMap model) throws GlobalCustomException {

//        Object[] dsd = listCheckboxCharacteristicNameValue.get("listCheckboxCharacteristicNameValue[]").toArray();
        if (result.hasErrors()) {
            model.addAttribute("characteristicType", CharacteristicTypeEnum.values());
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


}
