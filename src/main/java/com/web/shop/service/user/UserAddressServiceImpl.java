package com.web.shop.service.user;

import com.web.shop.dao.user.AddressDao;
import com.web.shop.dto.user.UserAddressDTO;
import com.web.shop.model.user.UserAddress;
import com.web.shop.service.interfaces.user.UserAddressService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service("addressService")
public class UserAddressServiceImpl extends GenericServiceImpl<UserAddressDTO, Integer, AddressDao, UserAddress> implements UserAddressService {
}
