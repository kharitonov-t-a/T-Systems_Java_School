package com.web.shop.dao.product;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.product.ProductCharacteristicType;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("productCharacteristicTypeDao")
public class ProductCharacteristicTypeDaoImpl extends GenericDaoImpl<ProductCharacteristicType, Integer> implements ProductCharacteristicTypeDao {

    public List<ProductCharacteristicType> findByType(String Type){
        try{
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCharacteristicType u WHERE u.characteristicType = :Type")
                    .setParameter("Type", Type)
                    .getResultList();
        }catch(NoResultException ex){
            return null;
        }
    }

    @Override
    public List<ProductCharacteristicType> findByCatalogId(Integer catalogId) {
        try{
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCharacteristicType u WHERE u.productCategory.id = :catalogId ORDER BY u.characteristicType")
                    .setParameter("catalogId", catalogId)
                    .getResultList();
        }catch(NoResultException ex){
            return null;
        }
    }

}
