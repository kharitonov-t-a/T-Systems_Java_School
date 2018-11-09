package com.web.shop.service.front.products;

import com.web.shop.constants.CheckProductsCategoryExceptionMessage;
import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.service.interfaces.products.ProductsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productsCategoryService")
public class ProductsCategoryServiceFront implements ProductsCategoryService {

    @Autowired
    ProductsCategoryService productsCategoryServiceTransact;

    public ProductsCategoryDTO findById(Integer id) {
        return productsCategoryServiceTransact.findById(id);
    }

    public List<ProductsCategoryDTO> findByParent(Integer parent) {
        return productsCategoryServiceTransact.findByParent(parent);
    }

    public List<ProductsCategoryDTO> findSlaveNodesById(Integer id) {
        return productsCategoryServiceTransact.findSlaveNodesById(id);
    }

    public List<ProductsCategoryDTO> findParentBranchById(Integer id) {
        return productsCategoryServiceTransact.findParentBranchById(id);
    }

    public List<ProductsCategoryDTO> findCurrentBranchById(Integer id) {
        return productsCategoryServiceTransact.findCurrentBranchById(id);
    }

    public List<ProductsCategoryDTO> findAll() {
        return productsCategoryServiceTransact.findAll();
    }

    public List<ProductsCategoryDTO> checkLeftMoreRight() throws CheckProductsCategoryException {
               List<ProductsCategoryDTO> listProductsCategoryDTO = productsCategoryServiceTransact.checkLeftMoreRight();
            if(listProductsCategoryDTO.size() != 0)
                throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.LEFT_MORE_RIGHT, listProductsCategoryDTO);
        return listProductsCategoryDTO;
    }

    public boolean checkCountMinMax() throws CheckProductsCategoryException {
        if(!productsCategoryServiceTransact.checkCountMinMax())
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.COUNT_MIN_MAX);
        return true;
    }

    public List<ProductsCategoryDTO> checkModRightLeft() throws CheckProductsCategoryException {
        List<ProductsCategoryDTO> listProductsCategoryDTO = productsCategoryServiceTransact.checkModRightLeft();
        if(listProductsCategoryDTO.size() != 0)
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.MOD_RIGHT_LEFT, listProductsCategoryDTO);
        return listProductsCategoryDTO;
    }

    public List<ProductsCategoryDTO> checkModLeftLevel() throws CheckProductsCategoryException {
        List<ProductsCategoryDTO> listProductsCategoryDTO = productsCategoryServiceTransact.checkModLeftLevel();
        if(listProductsCategoryDTO.size() != 0)
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.MOD_LEFT_LEVEL, listProductsCategoryDTO);
        return listProductsCategoryDTO;
    }

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

    public void create(ProductsCategoryDTO productsCategoryDTO) throws GlobalCustomException {
        checkIntegrityTree();
        productsCategoryServiceTransact.create(productsCategoryDTO);
    }

    public void delete(Integer id) throws GlobalCustomException {
        checkIntegrityTree();
        productsCategoryServiceTransact.delete(id);
    }
}
