package com.web.shop.dao.product;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.dao.interfaces.product.ProductCharacteristicCheckboxFieldDao;
import com.web.shop.model.product.ProductCharacteristicCheckboxField;
import org.springframework.stereotype.Repository;

@Repository("productCharacteristicCheckboxFieldDao")
public class ProductCharacteristicCheckboxFieldDaoImpl extends GenericDaoImpl<ProductCharacteristicCheckboxField, Integer> implements ProductCharacteristicCheckboxFieldDao {
    @Override
    public void deleteByProductCharacteristicTypeId(Integer id) {
        getEntityManager()
                .createQuery("DELETE FROM ProductCharacteristicCheckboxField u WHERE u.productCharacteristicType.id = :productCharacteristicTypeId")
                .setParameter("productCharacteristicTypeId", id)
                .executeUpdate();

    }

}
