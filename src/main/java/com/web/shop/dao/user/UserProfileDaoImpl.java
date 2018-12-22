package com.web.shop.dao.user;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.dao.interfaces.user.UserProfileDao;
import com.web.shop.model.user.UserProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository("userProfileDao")
public class UserProfileDaoImpl  extends GenericDaoImpl<UserProfile, Integer> implements UserProfileDao {

    public UserProfile findByRole(String role) {
        System.out.println("role: "+role);
        try{
            UserProfile userProfile = (UserProfile) getEntityManager()
                    .createQuery("SELECT p FROM UserProfile p WHERE p.role LIKE :role")
                    .setParameter("role", role)
                    .getSingleResult();
            return userProfile;
        }catch(NoResultException ex){
            return null;
        }
    }

//    public List<UserProfile> findAll(){
//        return (List<UserProfile>) getEntityManager()
//                .createQuery("SELECT p FROM UserProfile p  ORDER BY p.role ASC")
//                .getResultList();
//    }

}
