package com.web.shop.dao.orders;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.dao.users.AddressDao;
import com.web.shop.model.orders.Order;
import com.web.shop.model.users.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends GenericDaoImpl<Order, Integer> implements OrderDao {
    @Override
    public List<Order> findByUserId(Integer userId) {
        try{
            return getEntityManager()
                    .createQuery("SELECT u FROM Order u WHERE u.user.id LIKE :userId")
                    .setParameter(userId, userId)
                    .getResultList();
        }catch(NoResultException ex){
            return null;
        }
    }
}
