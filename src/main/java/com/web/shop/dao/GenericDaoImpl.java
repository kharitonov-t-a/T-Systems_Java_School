package com.web.shop.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDaoImpl <T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl(){
//        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public final void setPersistentClass( Class< T > persistentClass ){
        this.persistentClass = persistentClass;
    }

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager(){
        return this.entityManager;
    }

    public T findById(PK key) {
        return (T) entityManager.find(persistentClass, key);
    }

    public void create(T entity) {
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
}