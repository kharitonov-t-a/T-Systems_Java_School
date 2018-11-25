package com.web.shop.dao.product;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.dto.product.ProductCategoryDTO;
import com.web.shop.model.product.ProductCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("productCategoryDao")
public class ProductCategoryDaoImpl extends GenericDaoImpl<ProductCategory, Integer> implements ProductCategoryDao {

    @Override
    public List<ProductCategory> findByParent(Integer parent) {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCategory u WHERE u.parent = :parent ORDER BY u.leftKey")
                    .setParameter("parent", parent)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductCategory> findSlaveNodes(Integer leftKey, Integer rightKey) {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCategory u WHERE u.leftKey >= :leftKey AND u.rightKey <= :rightKey ORDER BY u.leftKey")
                    .setParameter("leftKey", leftKey)
                    .setParameter("rightKey", rightKey)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductCategory> findParentBranch(Integer leftKey, Integer rightKey) {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCategory u WHERE u.leftKey <= :leftKey AND u.rightKey >= :rightKey ORDER BY u.leftKey")
                    .setParameter("leftKey", leftKey)
                    .setParameter("rightKey", rightKey)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductCategory> findCurrentBranch(Integer leftKey, Integer rightKey) {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCategory u WHERE u.rightKey > :leftKey AND u.leftKey < :rightKey ORDER BY u.leftKey")
                    .setParameter("leftKey", leftKey)
                    .setParameter("rightKey", rightKey)
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }



    @Override
    public List<ProductCategory> findAll() {
        return getEntityManager().createQuery("SELECT u FROM ProductCategory u WHERE u.id <> 0 ORDER BY u.leftKey")
                .getResultList();
    }

    /*-------------------------------- check Products ProductCategory Structure --------------------------------*/


    @Override
    public List<ProductCategory> selectLeftMoreRight() {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCategory u WHERE u.leftKey >= u.rightKey AND u.id <> 0")
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List selectCountMinMax() {
        try {
            return getEntityManager()
                    .createQuery("SELECT COUNT(u.id), MIN(u.leftKey), MAX(u.rightKey) FROM ProductCategory u WHERE u.id <> 0")
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductCategory> selectByModRightLeft() {
        try {
            return getEntityManager()
                    .createQuery("SELECT u FROM ProductCategory u WHERE MOD((u.rightKey - u.leftKey), 2) = 0  AND u.id <> 0")
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductCategory> selectByModLeftLevel() {
        try {
            List<ProductCategory> productsCategories =
                    (List<ProductCategory>)getEntityManager()
                    .createNativeQuery("SELECT u.* FROM ProductCategory u WHERE MOD((u.leftKey - u.level + 2), 2) = 1  AND u.id <> 0")
                    .getResultList();
            return productsCategories;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<ProductCategory> selectNotUniqueNods() {
        try {
            return (List<ProductCategory>)getEntityManager()
                    .createNativeQuery("SELECT u1.*, COUNT(u1.id) AS rep, MAX(u3.rightKey) AS maxright " +
                            " FROM ProductCategory AS u1, ProductCategory AS u2, ProductCategory AS u3 " +
                            " WHERE u1.leftKey <> u2.leftKey AND u1.leftKey <> u2.rightKey AND u1.rightKey <> u2.leftKey AND u1.rightKey <> u2.rightKey AND u1.id <> 0 AND u2.id <> 0 AND u3.id <> 0" +
                            " GROUP BY u1.id HAVING maxright <> SQRT(4 * rep + 1) + 1")
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public void updateBranchesBeforeCreate(Integer parentRightKey) {
        getEntityManager()
                .createNativeQuery("UPDATE ProductCategory u " +
                        "SET u.rightKey = u.rightKey + 2, u.leftKey = IF(u.leftKey > :parentRightKey, u.leftKey + 2, u.leftKey) " +
                        "WHERE u.rightKey >= :parentRightKey AND u.id <> 0")
                .setParameter("parentRightKey", parentRightKey).executeUpdate();
    }

    public void updateBranchesAfterDelete(Integer leftKey, Integer rightKey) {
        getEntityManager()
                .createNativeQuery("UPDATE ProductCategory u " +
                        "SET u.leftKey = IF(u.leftKey > :leftKey, u.leftKey-(:rightKey - :leftKey + 1), u.leftKey), u.rightKey = u.rightKey-(:rightKey - :leftKey + 1)" +
                        "WHERE u.rightKey > :rightKey AND u.id <> 0")
                .setParameter("rightKey", rightKey)
                .setParameter("leftKey", leftKey).executeUpdate();
    }

    @Override
    public void deleteSlaveNodes(Integer leftKey, Integer rightKey) {
        getEntityManager()
                .createQuery("DELETE FROM ProductCategory u WHERE u.leftKey >= :leftKey AND u.rightKey <= :rightKey")
                .setParameter("leftKey", leftKey)
                .setParameter("rightKey", rightKey)
                .executeUpdate();
    }

    @Override
    public ProductCategory findNodeByCharacterCode(String characterCode) {
        try {
            return (ProductCategory) getEntityManager()
                    .createQuery("SELECT u FROM ProductCategory u WHERE u.characterCode = :characterCode ")
                    .setParameter("characterCode", characterCode)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }    }


}
