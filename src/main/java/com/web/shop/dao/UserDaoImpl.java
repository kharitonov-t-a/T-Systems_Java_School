package com.web.shop.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import com.web.shop.model.User;
import org.springframework.stereotype.Repository;



@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public User findById(int id) {
        User user = getByKey(id);
        return user;
    }

    public void deleteById(int id) {
        User user = getByKey(id);
        delete(user);
    }

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

    @Override
    public void deleteByEmail(String email) {
        User user = findByEmail(email);
        if (user != null)
            deleteById(user.getId());
    }

//
//    public void deleteBySSO(String sso) {
//        User user = (User) getEntityManager()
//                .createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
//                .setParameter("ssoId", sso)
//                .getSingleResult();
//        delete(user);
//    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        List<User> users = getEntityManager()
                .createQuery("SELECT u FROM User u ORDER BY u.id ASC")
                .getResultList();
        return users;
    }

    public void saveUser(User user) {
        persist(user);
    }

    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

}