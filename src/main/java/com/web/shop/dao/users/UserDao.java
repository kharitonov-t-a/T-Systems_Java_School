package com.web.shop.dao.users;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.users.User;

public interface UserDao extends GenericDao<User, Integer> {

    User findByEmail(String eMail);

    void deleteByEmail(String eMail);

}
