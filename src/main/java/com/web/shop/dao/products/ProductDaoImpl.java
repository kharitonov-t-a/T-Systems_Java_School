package com.web.shop.dao.products;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.orders.OrderProduct;
import com.web.shop.model.products.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import java.util.List;

@Repository("productsDao")
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
                    .createNativeQuery("SELECT u.* FROM Products u WHERE u.id IN (" + ids + ") AND u.StockQuantity < 1 FOR UPDATE")
                    .getResultList();
        } catch (NoResultException ex){
            return null;
        }
    }

    @Override
    public Product findByIdForUpdate(Integer id) {
        return getEntityManager().find(Product.class, id, LockModeType.PESSIMISTIC_WRITE);
    }


}
