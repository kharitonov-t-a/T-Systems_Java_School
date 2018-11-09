package com.web.shop.dao.products;

import com.web.shop.dao.GenericDao;
import com.web.shop.model.products.ProductsCategory;

import java.util.List;

public interface ProductsCategoryDao extends GenericDao<ProductsCategory, Integer> {

    List<ProductsCategory> findByParent(Integer parent);
    List<ProductsCategory> findSlaveNodes(Integer leftKey, Integer rightKey);
    List<ProductsCategory> findParentBranch(Integer leftKey, Integer rightKey);
    List<ProductsCategory> findCurrentBranch(Integer leftKey, Integer rightKey);

    List<ProductsCategory> selectLeftMoreRight();
    List selectCountMinMax();
    List<ProductsCategory> selectByModRightLeft();
    List selectByModLeftLevel();
    List<ProductsCategory> selectNotUniqueNods();

    void updateBranchesBeforeCreate(Integer parentRightKey);
    void updateBranchesAfterDelete(Integer leftKey, Integer rightKey);

    void deleteSlaveNodes(Integer leftKey, Integer rightKey);
}
