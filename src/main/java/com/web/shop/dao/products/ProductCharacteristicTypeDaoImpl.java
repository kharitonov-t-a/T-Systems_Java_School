package com.web.shop.dao.products;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.products.ProductCharacteristicType;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("productCharacteristicTypeDao")
public class ProductCharacteristicTypeDaoImpl extends GenericDaoImpl<ProductCharacteristicType, Integer> implements ProductCharacteristicTypeDao {

    public List<ProductCharacteristicType> findByType(String Type){
        try{
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCharacteristicType u WHERE u.Type LIKE :Type")
                    .setParameter("Type", Type)
                    .getResultList();
        }catch(NoResultException ex){
            return null;
        }
    }

}
