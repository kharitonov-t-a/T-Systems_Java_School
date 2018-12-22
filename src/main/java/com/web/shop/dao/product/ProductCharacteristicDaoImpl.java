package com.web.shop.dao.product;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.dao.interfaces.product.ProductCharacteristicDao;
import com.web.shop.model.product.ProductCharacteristic;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("productCharacteristicDao")
public class ProductCharacteristicDaoImpl extends GenericDaoImpl<ProductCharacteristic, Integer> implements ProductCharacteristicDao {
    @Override
    public List<ProductCharacteristic> findByProductId(Integer productId) {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCharacteristic u WHERE u.product.id = :productId")
                    .setParameter("productId", this.findById(productId))
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
