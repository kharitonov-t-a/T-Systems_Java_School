package com.web.shop.dao.product;

import com.web.shop.dao.GenericDao;
import com.web.shop.dto.product.ProductCategoryDTO;
import com.web.shop.model.product.ProductCategory;

import java.util.List;

public interface ProductCategoryDao extends GenericDao<ProductCategory, Integer> {

    List<ProductCategory> findByParent(Integer parent);
    List<ProductCategory> findSlaveNodes(Integer leftKey, Integer rightKey);
    List<ProductCategory> findParentBranch(Integer leftKey, Integer rightKey);
    List<ProductCategory> findCurrentBranch(Integer leftKey, Integer rightKey);

    List<ProductCategory> selectLeftMoreRight();
    List selectCountMinMax();
    List<ProductCategory> selectByModRightLeft();
    List<ProductCategory> selectByModLeftLevel();
    List<ProductCategory> selectNotUniqueNods();

    void updateBranchesBeforeCreate(Integer parentRightKey);
    void updateBranchesAfterDelete(Integer leftKey, Integer rightKey);

    void deleteSlaveNodes(Integer leftKey, Integer rightKey);

    ProductCategory findNodeByCharacterCode(String characterCode);
}
