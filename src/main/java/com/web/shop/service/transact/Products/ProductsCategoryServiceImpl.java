package com.web.shop.service.transact.Products;

import com.web.shop.dao.Products.ProductsCategoryDao;
import com.web.shop.dto.Products.ProductsCategoryDTO;
import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.model.Products.ProductsCategory;
import com.web.shop.model.Users.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("productsCategoryServiceTransact")
public class ProductsCategoryServiceImpl implements ProductsCategoryService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ProductsCategoryDao dao;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public ProductsCategoryDTO findById(int id) {
        return modelMapper.map(dao.findById(id), ProductsCategoryDTO.class) ;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> findByParent(Integer parent) {
        return mapListsEntityToDTO(dao.findByParent(parent));
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> findSlaveNodesById(Integer id) {
        ProductsCategory productsCategory = dao.findById(id);
        return mapListsEntityToDTO(dao.findSlaveNodes(productsCategory.getLeftKey(), productsCategory.getRightKey()));
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> findParentBranchById(Integer id) {
        ProductsCategory productsCategory = dao.findById(id);
        return mapListsEntityToDTO(dao.findParentBranch(productsCategory.getLeftKey(), productsCategory.getRightKey()));
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> findCurrentBranchById(Integer id) {
        ProductsCategory productsCategory = dao.findById(id);
        return mapListsEntityToDTO(dao.findCurrentBranch(productsCategory.getLeftKey(), productsCategory.getRightKey()));
    }


    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> findAll() {
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        modelMapper.typeMap(ProductsCategory.class, ProductsCategoryDTO.class)
//                .addMappings(m -> m.map(src -> src.getParent().getId(), ProductsCategoryDTO::setParent));
        return mapListsEntityToDTO(dao.findAll());
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveNewProductsCategory(ProductsCategoryDTO productsCategoryDTO) {

        ProductsCategory parentProductsCategory = dao.findById(productsCategoryDTO.getParent());

        dao.updateBranchesBeforeCreate(parentProductsCategory.getRightKey());

        productsCategoryDTO.setLeftKey(parentProductsCategory.getRightKey());
        productsCategoryDTO.setRightKey(parentProductsCategory.getRightKey() + 1);
        productsCategoryDTO.setLevel(parentProductsCategory.getLevel() + 1);
        dao.create(modelMapper.map(productsCategoryDTO, ProductsCategory.class));
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteProductsCategory(Integer id) throws CheckProductsCategoryException {
        ProductsCategory roductsCategory = dao.findById(id);
        dao.deleteSlaveNodes(roductsCategory.getLeftKey(), roductsCategory.getRightKey());
        dao.updateBranchesAfterDelete(roductsCategory.getLeftKey(), roductsCategory.getRightKey());
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> checkLeftMoreRight() {
        return mapListsEntityToDTO(dao.selectLeftMoreRight());
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public boolean checkCountMinMax() {
        List list = dao.selectCountMinMax();
        Object[] objectsCountMinMax = (Object[]) list.get(0);
        if(Integer.parseInt(objectsCountMinMax[1].toString()) != 1 ||
                (Integer.parseInt(objectsCountMinMax[2].toString()) != Integer.parseInt(objectsCountMinMax[0].toString()) * 2))
            return false;
        return true;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> checkModRightLeft() {
        return mapListsEntityToDTO(dao.selectByModRightLeft());
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> checkModLeftLevel() {
        return mapListsEntityToDTO(dao.selectByModLeftLevel());
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> checkNotUniqueNods() {
        return mapListsEntityToDTO(dao.selectNotUniqueNods());
    }

    private List<ProductsCategoryDTO> mapListsEntityToDTO(List<ProductsCategory> listProductsCategory){
        List<ProductsCategoryDTO> listProductsCategoryDTO = new ArrayList<>();
        for (ProductsCategory productsCategory : listProductsCategory) {
            listProductsCategoryDTO.add(modelMapper.map(productsCategory, ProductsCategoryDTO.class));
        }
        return listProductsCategoryDTO;
    }

}
