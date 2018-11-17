package com.web.shop.dao.user;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.user.UserAddress;
import org.springframework.stereotype.Repository;

@Repository("addressDao")
public class AddressDaoImpl extends GenericDaoImpl<UserAddress, Integer> implements AddressDao {
}
