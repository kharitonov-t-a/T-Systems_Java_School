package com.web.shop.dao.product;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.product.ProductCategory;
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
    public List<ProductCharacteristicType> findByCategory(ProductCategory productCategory) {
        try{
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCharacteristicType u WHERE u.productCategory.leftKey <= :leftKey AND u.productCategory.rightKey >= :rightKey ORDER BY u.id")
                    .setParameter("leftKey", productCategory.getLeftKey())
                    .setParameter("rightKey", productCategory.getRightKey())
                    .getResultList();
        }catch(NoResultException ex){
            return null;
        }
    }

}
