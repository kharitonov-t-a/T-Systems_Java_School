package com.web.shop.dao.products;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.dto.products.ProductCharacteristicDTO;
import com.web.shop.model.products.CheckboxCharacteristicValues;
import com.web.shop.model.products.ProductCharacteristic;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("productCharacteristicDao")
public class ProductCharacteristicDaoImpl extends GenericDaoImpl<ProductCharacteristic, Integer> implements ProductCharacteristicDao{
    @Override
    public List<ProductCharacteristic> findByProductId(Integer productId) {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCharacteristic u WHERE u.product LIKE :product")
                    .setParameter("product", this.findById(productId))
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
