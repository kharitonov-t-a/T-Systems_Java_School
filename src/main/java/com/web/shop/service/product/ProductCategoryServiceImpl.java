package com.web.shop.service.product;

import com.web.shop.constants.CheckProductsCategoryExceptionMessage;
import com.web.shop.dao.product.ProductCategoryDao;
import com.web.shop.dao.product.ProductDao;
import com.web.shop.dto.product.ProductCategoryDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.exceptions.CreateDaoException;
import com.web.shop.model.product.ProductCategory;
import com.web.shop.service.interfaces.product.ProductCategoryService;
import com.web.shop.service.GenericServiceImpl;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("productCategoryService")
public class ProductCategoryServiceImpl extends GenericServiceImpl<ProductCategoryDTO, Integer, ProductCategoryDao, ProductCategory> implements ProductCategoryService {

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductCategoryService productCategoryService;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public boolean checkIntegrityTree() throws CheckProductsCategoryException {
        return checkLeftMoreRight() &&
                checkCountMinMax() &&
                checkModRightLeft() &&
                checkModLeftLevel() &&
                checkNotUniqueNods();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createNode(ProductCategoryDTO productCategoryDTO) throws CheckProductsCategoryException {
        checkIntegrityTree();
        create(productCategoryDTO);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteNode(Integer id) throws CheckProductsCategoryException {
        checkIntegrityTree();
        delete(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateNode(ProductCategoryDTO productCategoryDTO) throws CheckProductsCategoryException {
        checkIntegrityTree();
        update(productCategoryDTO);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public ProductCategoryDTO findNodeByCharacterCode(String characterCode) {
        ProductCategory productCategory = dao.findNodeByCharacterCode(characterCode);
        if(productCategory == null)
            return null;
        else
            return modelMapper.map(productCategory, ProductCategoryDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductCategoryDTO> findByParent(Integer parent) {
        return modelMapper.mapListsEntityToDTO(dao.findByParent(parent), ProductCategoryDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductCategoryDTO> findSlaveNodesById(Integer id) {
        ProductCategory productCategory = dao.findById(id);
        return findSlaveNodes(productCategory.getLeftKey(), productCategory.getRightKey());
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductCategoryDTO> findSlaveNodes(Integer leftKey, Integer rightKey) {
        return modelMapper.mapListsEntityToDTO(dao.findSlaveNodes(leftKey, rightKey), ProductCategoryDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductCategoryDTO> findParentBranchById(Integer id) {
        ProductCategory productCategory = dao.findById(id);
        return modelMapper.mapListsEntityToDTO(dao.findParentBranch(productCategory.getLeftKey(), productCategory.getRightKey()), ProductCategoryDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductCategoryDTO> findCurrentBranchById(Integer id) {
        ProductCategory productCategory = dao.findById(id);
        return modelMapper.mapListsEntityToDTO(dao.findCurrentBranch(productCategory.getLeftKey(), productCategory.getRightKey()), ProductCategoryDTO.class);
    }

//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public List<ProductCategoryDTO> findAll() {
////        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
////        modelMapper.typeMap(ProductCategory.class, ProductCategoryDTO.class)
////                .addMappings(m -> m.map(src -> src.getParent().getId(), ProductCategoryDTO::setParent));
//        return modelMapper.mapListsEntityToDTO(dao.findAll(), ProductCategoryDTO.class);
//    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductCategoryDTO productCategoryDTO) {

        ProductCategory parentProductCategory = dao.findById(productCategoryDTO.getParent());

        dao.updateBranchesBeforeCreate(parentProductCategory.getRightKey());

        productCategoryDTO.setLeftKey(parentProductCategory.getRightKey());
        productCategoryDTO.setRightKey(parentProductCategory.getRightKey() + 1);
        productCategoryDTO.setLevel(parentProductCategory.getLevel() + 1);

//        try {
            dao.create(modelMapper.map(productCategoryDTO, ProductCategory.class));
//        }catch (Exception e){
//            throw new CreateDaoException();
//        }

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(ProductCategoryDTO productCategoryDTO) {

        ProductCategory productCategory = dao.findById(productCategoryDTO.getParent());
        productCategory.setName(productCategoryDTO.getName());
        productCategory.setCharacterCode(productCategoryDTO.getCharacterCode());

        dao.update(productCategory);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(Integer id) {

        ProductCategory productsProductCategory = dao.findById(id);
        List<ProductCategory> productsCategories = dao.findSlaveNodes(productsProductCategory.getLeftKey(), productsProductCategory.getRightKey());

        productsCategories.forEach(productCategory -> productDao.setCategoryToNull(productCategory.getId()));

        dao.deleteSlaveNodes(productsProductCategory.getLeftKey(), productsProductCategory.getRightKey());
        dao.updateBranchesAfterDelete(productsProductCategory.getLeftKey(), productsProductCategory.getRightKey());
    }


    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public boolean checkLeftMoreRight() throws CheckProductsCategoryException {
        List<ProductCategory> productCategoryList = dao.selectLeftMoreRight();
//        productCategoryList.forEach(productCategory -> productCategory.setProductList(new ArrayList<>()));

        List<ProductCategoryDTO> listProductCategoryDTO = modelMapper.mapListsEntityToDTO(productCategoryList, ProductCategoryDTO.class);
        if (listProductCategoryDTO.size() != 0)
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.LEFT_MORE_RIGHT, listProductCategoryDTO);
        return true;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public boolean checkCountMinMax() throws CheckProductsCategoryException {
        List list = dao.selectCountMinMax();
        Object[] objectsCountMinMax = (Object[]) list.get(0);
        if (Integer.parseInt(objectsCountMinMax[1].toString()) != 1 ||
                (Integer.parseInt(objectsCountMinMax[2].toString()) != Integer.parseInt(objectsCountMinMax[0].toString())    * 2))
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.COUNT_MIN_MAX);
        return true;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public boolean checkModRightLeft() throws CheckProductsCategoryException {

        List<ProductCategoryDTO> listProductCategoryDTO = modelMapper.mapListsEntityToDTO(dao.selectByModRightLeft(), ProductCategoryDTO.class);
        if (listProductCategoryDTO.size() != 0)
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.MOD_RIGHT_LEFT, listProductCategoryDTO);
        return true;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public boolean checkModLeftLevel() throws CheckProductsCategoryException {

        List<ProductCategoryDTO> listProductCategoryDTO = modelMapper.mapListsEntityToDTO(dao.selectByModLeftLevel(), ProductCategoryDTO.class);
        if (listProductCategoryDTO.size() != 0)
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.MOD_LEFT_LEVEL, listProductCategoryDTO);
        return true;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public boolean checkNotUniqueNods() throws CheckProductsCategoryException {

        List<ProductCategoryDTO> listProductCategoryDTO = modelMapper.mapListsEntityToDTO(dao.selectNotUniqueNods(), ProductCategoryDTO.class);
        if (listProductCategoryDTO.size() != 0)
            throw new CheckProductsCategoryException(CheckProductsCategoryExceptionMessage.NOT_UNIQUE_NODS, listProductCategoryDTO);
        return true;
    }


}
