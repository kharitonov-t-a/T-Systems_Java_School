package com.web.shop.service.interfaces.product;

import com.web.shop.dto.product.ProductCategoryDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.service.GenericService;

import java.util.List;

public interface ProductCategoryService extends GenericService<ProductCategoryDTO, Integer> {


    List<ProductCategoryDTO> findByParent(Integer parent);

    List<ProductCategoryDTO> findSlaveNodesById(Integer id);

    List<ProductCategoryDTO> findParentBranchById(Integer id);

    List<ProductCategoryDTO> findCurrentBranchById(Integer id);

    boolean checkLeftMoreRight() throws CheckProductsCategoryException;

    boolean checkCountMinMax() throws CheckProductsCategoryException;

    boolean checkModRightLeft() throws CheckProductsCategoryException;

    boolean checkModLeftLevel() throws CheckProductsCategoryException;

    boolean checkNotUniqueNods() throws CheckProductsCategoryException;

    List<ProductCategoryDTO> findSlaveNodes(Integer leftKey, Integer rightKey);

    void createNod(ProductCategoryDTO productCategoryDTO);

    void deleteNod(Integer id);

//    ProductCategoryDTO findById(Integer id);
//    List<ProductCategoryDTO> findAll();
//    void create(ProductCategoryDTO productsCategoryDTO) throws CheckProductsCategoryException;
//    void delete(Integer id) throws CheckProductsCategoryException;


}
