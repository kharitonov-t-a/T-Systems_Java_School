package com.web.shop.service.transact.users;

import com.web.shop.dao.users.AddressDao;
import com.web.shop.dao.users.UserProfileDao;
import com.web.shop.dto.users.AddressDTO;
import com.web.shop.dto.users.UserProfileDTO;
import com.web.shop.model.users.Address;
import com.web.shop.model.users.UserProfile;
import com.web.shop.service.interfaces.users.AddressService;
import com.web.shop.service.interfaces.users.UserProfileService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.springframework.stereotype.Service;

@Service("addressServiceTransact")
public class AddressServiceTransactImpl extends GenericServiceTransactImpl<AddressDTO, Integer, AddressDao, Address> implements AddressService {
}
