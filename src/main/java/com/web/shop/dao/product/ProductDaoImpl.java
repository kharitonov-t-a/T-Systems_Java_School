package com.web.shop.dao.product;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.order.OrderProduct;
import com.web.shop.model.product.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends GenericDaoImpl<Product, Integer> implements ProductDao {
    @Override
    public List<Product> findAllByIds(List<OrderProduct> orderProducts) {

        StringBuffer ids = new StringBuffer();
        orderProducts.forEach(
                (i)->ids.append("," + i.getProduct().getId())
        );
        ids.deleteCharAt(0);
        try {
//            getEntityManager().find(id, Product.class, LockModeType.PESSIMISTIC_WRITE);
            return (List<Product>) getEntityManager()
                    .createQuery("SELECT u FROM Product u WHERE u.id IN (" + ids + ") AND u.stockQuantity < 1 FOR UPDATE")
                    .getResultList();
        } catch (NoResultException ex){
            return null;
        }
    }

    @Override
    public Product findByIdForUpdate(Integer id) {
        return getEntityManager().find(Product.class, id, LockModeType.PESSIMISTIC_WRITE);
    }

    @Override
    public void setCategoryToNull(Integer categoryId) {
        getEntityManager()
                .createQuery("UPDATE Product u " +
                        "SET u.productCategory.id = 0 " +
                        "WHERE u.productCategory.id = :categoryId")
                .setParameter("categoryId", categoryId)
                .executeUpdate();
    }


}
