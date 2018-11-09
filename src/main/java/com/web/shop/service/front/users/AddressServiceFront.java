package com.web.shop.service.front.users;

import com.web.shop.dto.users.AddressDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.users.AddressService;
import com.web.shop.service.interfaces.users.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressService")
public class AddressServiceFront implements AddressService {

    @Autowired
    AddressService addressServiceTransact;

    @Override
    public AddressDTO findById(Integer id) {
        return addressServiceTransact.findById(id);
    }

    @Override
    public void create(AddressDTO addressDTO) throws GlobalCustomException {
        addressServiceTransact.create(addressDTO);
    }

    @Override
    public void delete(Integer id) throws GlobalCustomException {
        addressServiceTransact.delete(id);
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressServiceTransact.findAll();
    }
}
