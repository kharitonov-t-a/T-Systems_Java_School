package com.web.shop.dao;

import com.web.shop.model.UserProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile>implements UserProfileDao{

    public UserProfile findById(int id) {
        return getByKey(id);
    }

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

    @SuppressWarnings("unchecked")
    public List<UserProfile> findAll(){
        List<UserProfile> userProfiles = getEntityManager()
                .createQuery("SELECT p FROM UserProfile p  ORDER BY p.role ASC")
                .getResultList();
        return userProfiles;
    }

}
