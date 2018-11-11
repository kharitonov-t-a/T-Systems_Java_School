package com.web.shop.service.interfaces.products;

import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.service.GenericService;

import java.util.List;

public interface ProductsCategoryService extends GenericService<ProductsCategoryDTO, Integer> {


    List<ProductsCategoryDTO> findByParent(Integer parent);

    List<ProductsCategoryDTO> findSlaveNodesById(Integer id);

    List<ProductsCategoryDTO> findParentBranchById(Integer id);

    List<ProductsCategoryDTO> findCurrentBranchById(Integer id);

    List<ProductsCategoryDTO> checkLeftMoreRight() throws CheckProductsCategoryException;
    boolean checkCountMinMax() throws CheckProductsCategoryException;
    List<ProductsCategoryDTO> checkModRightLeft() throws CheckProductsCategoryException;
    List<ProductsCategoryDTO> checkModLeftLevel() throws CheckProductsCategoryException;
    List<ProductsCategoryDTO> checkNotUniqueNods() throws CheckProductsCategoryException;

    List<ProductsCategoryDTO> findSlaveNodes(Integer leftKey, Integer rightKey);

//    ProductsCategoryDTO findById(Integer id);
//    List<ProductsCategoryDTO> findAll();
//    void create(ProductsCategoryDTO productsCategoryDTO) throws CheckProductsCategoryException;
//    void delete(Integer id) throws CheckProductsCategoryException;


}
