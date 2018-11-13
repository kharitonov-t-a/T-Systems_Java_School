package com.web.shop.dao.orders;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.orders.OrderProduct;
import com.web.shop.model.products.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("orderProductDao")
public class OrderProductDaoImpl extends GenericDaoImpl<Product, Integer> implements OrderProductDao {

    @Override
    public void create(Product entity) {
        super.create(entity);
//        getEntityManager().close();
    }
}
