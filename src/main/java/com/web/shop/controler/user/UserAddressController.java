package com.web.shop.controler.user;

import com.web.shop.dto.user.UserAddressDTO;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.user.UserAddressService;
import com.web.shop.service.interfaces.user.UserService;
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
@RequestMapping("/user/address")
public class UserAddressController {
    @Autowired
    UserService userService;
    @Autowired
    UserAddressService userAddressService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String getCreateAddressForm(ModelMap model) {

        model.addAttribute("userAddressDTO", new UserAddressDTO());
        model.addAttribute("modalTitle", "Create Address");

        return "user/addressForm";
    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public String createAddress(@Validated({UserAddressDTO.ValidationAddress.class}) UserAddressDTO userAddressDTO, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "user/addressForm";
        }

        userAddressService.create(userAddressDTO);
        return "redirect:/user/address/list";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getEditAddressForm(@PathVariable String id, ModelMap model) {

        model.addAttribute("userAddressDTO", userAddressService.findById(Integer.valueOf(id)));
        model.addAttribute("modalTitle", "Change address");

        return "user/addressForm";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public String editAddress(@Validated({UserAddressDTO.ValidationAddress.class}) UserAddressDTO userAddressDTO, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "user/addressForm";
        }

        userAddressService.update(userAddressDTO);
        return addressList(model);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAddress(@PathVariable String id, ModelMap model) {

        userAddressService.delete(Integer.valueOf(id));

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String addressList(ModelMap model) {

        List<UserAddressDTO> userAddressDTOList = userService.findByEmail(UserSecurityService.getPrincipal()).getUserAddressList();

        model.addAttribute("userAddressDTOList", userAddressDTOList);

        return "user/addressList";
    }

}
