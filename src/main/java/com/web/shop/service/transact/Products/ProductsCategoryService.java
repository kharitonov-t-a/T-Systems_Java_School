package com.web.shop.service.transact.Products;

import com.web.shop.dto.Products.ProductsCategoryDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;

import java.util.List;

public interface ProductsCategoryService {

    ProductsCategoryDTO findById(int id);

    List<ProductsCategoryDTO> findByParent(Integer parent);

    List<ProductsCategoryDTO> findSlaveNodesById(Integer id);

    List<ProductsCategoryDTO> findParentBranchById(Integer id);

    List<ProductsCategoryDTO> findCurrentBranchById(Integer id);

    List<ProductsCategoryDTO> checkLeftMoreRight() throws CheckProductsCategoryException;
    boolean checkCountMinMax() throws CheckProductsCategoryException;
    List<ProductsCategoryDTO> checkModRightLeft() throws CheckProductsCategoryException;
    List<ProductsCategoryDTO> checkModLeftLevel() throws CheckProductsCategoryException;
    List<ProductsCategoryDTO> checkNotUniqueNods() throws CheckProductsCategoryException;

    List<ProductsCategoryDTO> findAll();

    void saveNewProductsCategory(ProductsCategoryDTO productsCategoryDTO) throws CheckProductsCategoryException;
    void deleteProductsCategory(Integer id) throws CheckProductsCategoryException;


}
