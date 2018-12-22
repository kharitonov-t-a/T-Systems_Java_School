package com.web.shop.service.user;

import com.web.shop.dao.interfaces.user.AddressDao;
import com.web.shop.dto.user.UserAddressDTO;
import com.web.shop.model.user.UserAddress;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.user.UserAddressService;
import com.web.shop.service.GenericServiceImpl;
import com.web.shop.service.interfaces.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("addressService")
public class UserAddressServiceImpl extends GenericServiceImpl<UserAddressDTO, Integer, AddressDao, UserAddress> implements UserAddressService {

    @Autowired
    UserService userService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void create(UserAddressDTO userAddressDTO) {
        userAddressDTO.setUser(userService.findByEmail(UserSecurityService.getPrincipal()));
        dao.create(modelMapper.map( userAddressDTO, UserAddress.class));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(UserAddressDTO userAddressDTO) {
        UserAddress entity = dao.findById(userAddressDTO.getId());
        if (entity != null) {
            if (userAddressDTO.getCountry() != null)
                entity.setCountry(userAddressDTO.getCountry());
            if (userAddressDTO.getCity() != null)
                entity.setCity(userAddressDTO.getCity());
            if (userAddressDTO.getStreet() != null)
                entity.setStreet(userAddressDTO.getStreet());
            if (userAddressDTO.getHouse() != null)
                entity.setHouse(userAddressDTO.getHouse());
            if (userAddressDTO.getFlat() != null)
                entity.setFlat(userAddressDTO.getFlat());
            if (userAddressDTO.getZip() != null)
                entity.setZip(userAddressDTO.getZip());
        }
    }
}
