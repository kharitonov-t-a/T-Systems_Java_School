package com.web.shop.dao.users;

import java.util.Collection;

import javax.persistence.NoResultException;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.users.User;
import org.springframework.stereotype.Repository;



@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

    public User findByEmail(String email) {
        System.out.println("Email : " +email);
        try{
            User user = (User) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.email LIKE :email")
                    .setParameter("email", email)
                    .getSingleResult();

            if(user!=null){
                initializeCollection(user.getUserProfiles());
            }
            return user;
        }catch(NoResultException ex){
            return null;
        }
    }

    public void deleteByEmail(String email) {
        User user = findByEmail(email);
        if (user != null)
            delete(user);
    }

//    public List<User> findAllUsers() {
//        List<User> users = getEntityManager()
//                .createQuery("SELECT u FROM User u ORDER BY u.id ASC")
//                .getResultList();
//        return users;
//    }

    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }
}