package com.web.shop.dao.users;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.users.Address;
import com.web.shop.model.users.User;
import org.springframework.stereotype.Repository;

@Repository("addressDao")
public class AddressDaoImpl extends GenericDaoImpl<Address, Integer> implements AddressDao {
}
