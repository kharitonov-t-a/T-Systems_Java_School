package com.web.shop.dao;

import com.web.shop.exceptions.SaveUserException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDaoImpl <T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager(){
        return this.entityManager;
    }

    public T findById(PK key) {
        return (T) entityManager.find(persistentClass, key);
    }

    public void create(T entity){
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(PK key) {
        entityManager.remove(findById(key));
    }

    public List< T > findAll(){
        return entityManager.createQuery( "from " + persistentClass.getName() )
                .getResultList();
    }

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    protected Session getSession(){
//        return sessionFactory.getCurrentSession();
//    }
//
//    @Bean
//    public static SessionFactory buildSessionFactory() {
//        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
//    }
//
//    protected Criteria getCriteria() {
//        return getSession().createCriteria(persistentClass);
//    }



//    protected Criteria createEntityCriteria(Session session) {
//        return session.createCriteria(persistentClass, "main").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//    }
//
//    protected Criteria createEntityCriteria() {
//        return createEntityCriteria(getSession());
//    }
}