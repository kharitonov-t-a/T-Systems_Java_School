package com.web.shop.dao.products;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.products.CheckboxCharacteristicNameValues;
import org.springframework.stereotype.Repository;

@Repository("checkboxCharacteristicNameValuesDao")
public class CheckboxCharacteristicNameValuesDaoImpl extends GenericDaoImpl<CheckboxCharacteristicNameValues, Integer> implements CheckboxCharacteristicNameValuesDao {
    @Override
    public void deleteByProductCharacteristicTypeId(Integer id) {
        getEntityManager()
                .createQuery("DELETE FROM CheckboxCharacteristicNameValues u WHERE u.productCharacteristicTypeId = :productCharacteristicTypeId")
                .setParameter("productCharacteristicTypeId", id)
                .executeUpdate();

    }

}
