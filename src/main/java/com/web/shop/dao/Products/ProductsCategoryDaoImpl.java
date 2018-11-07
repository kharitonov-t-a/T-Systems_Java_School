package com.web.shop.dao.Products;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.Products.ProductsCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaUpdate;
import java.util.List;

@Repository("productsCategoryDao")
public class ProductsCategoryDaoImpl extends GenericDaoImpl<ProductsCategory, Integer> implements ProductsCategoryDao {

    public ProductsCategoryDaoImpl() {
        setPersistentClass(ProductsCategory.class);
    }

    @Override
    public List<ProductsCategory> findByParent(Integer parent) {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductsCategory u WHERE u.parent LIKE :parent ORDER BY u.leftKey")
                    .setParameter("parent", parent)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductsCategory> findSlaveNodes(Integer leftKey, Integer rightKey) {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductsCategory u WHERE u.leftKey >= :leftKey AND u.rightKey <= :rightKey ORDER BY u.leftKey")
                    .setParameter("leftKey", leftKey)
                    .setParameter("rightKey", rightKey)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductsCategory> findParentBranch(Integer leftKey, Integer rightKey) {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductsCategory u WHERE u.leftKey <= :leftKey AND u.rightKey >= :rightKey ORDER BY u.leftKey")
                    .setParameter("leftKey", leftKey)
                    .setParameter("rightKey", rightKey)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductsCategory> findCurrentBranch(Integer leftKey, Integer rightKey) {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductsCategory u WHERE u.rightKey > :leftKey AND u.leftKey < :rightKey ORDER BY u.leftKey")
                    .setParameter("leftKey", leftKey)
                    .setParameter("rightKey", rightKey)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }



    @Override
    public List<ProductsCategory> findAll() {
        return getEntityManager().createQuery("SELECT u FROM ProductsCategory u ORDER BY u.leftKey")
                .getResultList();
    }

    /*-------------------------------- check Products Category Structure --------------------------------*/


    @Override
    public List<ProductsCategory> selectLeftMoreRight() {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductsCategory u WHERE u.leftKey >= u.rightKey")
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List selectCountMinMax() {
        try {
            return getEntityManager()
                    .createQuery("SELECT COUNT(u.id), MIN(u.leftKey), MAX(u.rightKey) FROM ProductsCategory u")
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductsCategory> selectByModRightLeft() {
        try {
            return getEntityManager()
                    .createNativeQuery("SELECT u.* FROM ProductsCategory u WHERE MOD((u.rightKey - u.leftKey), 2) = 0")
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductsCategory> selectByModLeftLevel() {
        try {
            return getEntityManager()
                    .createNativeQuery("SELECT u.* FROM ProductsCategory u WHERE MOD((u.leftKey - u.level + 2), 2) = 0")
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductsCategory> selectNotUniqueNods() {
        try {
            return (List<ProductsCategory>)getEntityManager()
                    .createNativeQuery("SELECT u1.*, COUNT(u1.id) AS rep, MAX(u3.rightKey) AS maxright " +
                            " FROM ProductsCategory AS u1, ProductsCategory AS u2, ProductsCategory AS u3 " +
                            " WHERE u1.leftKey <> u2.leftKey AND u1.leftKey <> u2.rightKey AND u1.rightKey <> u2.leftKey AND u1.rightKey <> u2.rightKey" +
                            " GROUP BY u1.id HAVING maxright <> SQRT(4 * rep + 1) + 1")
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public void updateBranchesBeforeCreate(Integer parentRightKey) {
        getEntityManager()
                .createNativeQuery("UPDATE ProductsCategory u " +
                        "SET u.rightKey = u.rightKey + 2, u.leftKey = IF(u.leftKey > :parentRightKey, u.leftKey + 2, u.leftKey) " +
                        "WHERE u.rightKey >= :parentRightKey")
                .setParameter("parentRightKey", parentRightKey).executeUpdate();
    }

    public void updateBranchesAfterDelete(Integer leftKey, Integer rightKey) {
        getEntityManager()
                .createNativeQuery("UPDATE ProductsCategory u " +
                        "SET u.leftKey = IF(u.leftKey > :leftKey, u.leftKey-(:rightKey - :leftKey + 1), u.leftKey), u.rightKey = u.rightKey-(:rightKey - :leftKey + 1)" +
                        "WHERE u.rightKey > :rightKey")
                .setParameter("rightKey", rightKey)
                .setParameter("leftKey", leftKey).executeUpdate();
    }

    @Override
    public void deleteSlaveNodes(Integer leftKey, Integer rightKey) {
        getEntityManager()
                .createQuery("DELETE FROM ProductsCategory u WHERE u.leftKey >= :leftKey AND u.rightKey <= :rightKey")
                .setParameter("leftKey", leftKey)
                .setParameter("rightKey", rightKey)
                .executeUpdate();
    }



}
