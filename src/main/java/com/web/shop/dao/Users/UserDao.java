package com.web.shop.dao.Users;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.Users.User;

public interface UserDao extends GenericDao<User, Integer> {

    User findByEmail(String eMail);

    void deleteByEmail(String eMail);

}
