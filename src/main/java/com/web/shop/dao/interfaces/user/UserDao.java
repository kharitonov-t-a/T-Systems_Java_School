package com.web.shop.dao.interfaces.user;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.user.User;

public interface UserDao extends GenericDao<User, Integer> {

    User findByEmail(String eMail);

    void deleteByEmail(String eMail);

}
