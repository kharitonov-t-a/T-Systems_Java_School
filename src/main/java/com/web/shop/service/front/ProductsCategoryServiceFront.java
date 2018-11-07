package com.web.shop.service.front;

import com.web.shop.constants.CheckProductsCategoryExceptionMessage;
import com.web.shop.dto.Products.ProductsCategoryDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.service.transact.Products.ProductsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productsCategoryService")
public class ProductsCategoryServiceFront implements ProductsCategoryService {

    @Autowired
    ProductsCategoryService productsCategoryServiceTransact;

    @Override
    public ProductsCategoryDTO findById(int id) {
        return productsCategoryServiceTransact.findById(id);
    }

    @Override
    public List<ProductsCategoryDTO> findByParent(Integer parent) {
        return productsCategoryServiceTransact.findByParent(parent);
    }

    @Override
    public List<ProductsCategoryDTO> findSlaveNodesById(Integer id) {
        return productsCategoryServiceTransact.findSlaveNodesById(id);
    }

    @Override
    public List<ProductsCategoryDTO> findParentBranchById(Integer id) {
        return productsCategoryServiceTransact.findParentBranchById(id);
    }

    @Override
    public List<ProductsCategoryDTO> findCurrentBranchById(Integer id) {
        return productsCategoryServiceTransact.findCurrentBranchById(id);
    }

    @Override
    public List<ProductsCategoryDTO> findAll() {
        return productsCategoryServiceTransact.findAll();
    }

    @Override
    public List<ProductsCategoryDTO> checkLeftMoreRight() throws CheckProductsCategoryException {
            List<ProductsCategoryDTO> listProductsCategoryDTO = productsCategoryServiceTransact.checkLeftMoreRight();
            if(listProductsCategoryDTO.size() != 0)
                throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.LEFT_MORE_RIGHT, listProductsCategoryDTO);
        return listProductsCategoryDTO;
    }

    @Override
    public boolean checkCountMinMax() throws CheckProductsCategoryException {
        if(!productsCategoryServiceTransact.checkCountMinMax())
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.COUNT_MIN_MAX);
        return true;
    }

    @Override
    public List<ProductsCategoryDTO> checkModRightLeft() throws CheckProductsCategoryException {
        List<ProductsCategoryDTO> listProductsCategoryDTO = productsCategoryServiceTransact.checkModRightLeft();
        if(listProductsCategoryDTO.size() != 0)
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.MOD_RIGHT_LEFT, listProductsCategoryDTO);
        return listProductsCategoryDTO;
    }

    @Override
    public List<ProductsCategoryDTO> checkModLeftLevel() throws CheckProductsCategoryException {
        List<ProductsCategoryDTO> listProductsCategoryDTO = productsCategoryServiceTransact.checkModLeftLevel();
        if(listProductsCategoryDTO.size() != 0)
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.MOD_LEFT_LEVEL, listProductsCategoryDTO);
        return listProductsCategoryDTO;
    }

    @Override
    public List<ProductsCategoryDTO> checkNotUniqueNods() throws CheckProductsCategoryException {
        List<ProductsCategoryDTO> listProductsCategoryDTO = productsCategoryServiceTransact.checkNotUniqueNods();
        if(listProductsCategoryDTO.size() != 0)
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.NOT_UNIQUE_NODS, listProductsCategoryDTO);
        return listProductsCategoryDTO;
    }

    public boolean checkIntegrityTree() throws CheckProductsCategoryException {
        checkLeftMoreRight();
        checkCountMinMax();
        checkModRightLeft();
        checkModLeftLevel();
        checkNotUniqueNods();
        return true;
    }

    public void saveNewProductsCategory(ProductsCategoryDTO productsCategoryDTO) throws CheckProductsCategoryException {
        checkIntegrityTree();
        productsCategoryServiceTransact.saveNewProductsCategory(productsCategoryDTO);
    }

    @Override
    public void deleteProductsCategory(Integer id) throws CheckProductsCategoryException {
        checkIntegrityTree();
        productsCategoryServiceTransact.deleteProductsCategory(id);
    }
}
