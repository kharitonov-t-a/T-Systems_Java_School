package com.web.shop.service.transact.products;

import com.web.shop.dao.products.ProductsCategoryDao;
import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.model.products.ProductsCategory;
import com.web.shop.service.interfaces.products.ProductsCategoryService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productsCategoryServiceTransact")
public class ProductsCategoryServiceTransactImpl extends GenericServiceTransactImpl<ProductsCategoryDTO, Integer, ProductsCategoryDao, ProductsCategory> implements ProductsCategoryService {

//    @Autowired
//    CustomModelMapper<ProductsCategoryDTO, ProductsCategory> modelMapper;

//    @Autowired
//    ProductsCategoryDao dao;

//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public ProductsCategoryDTO findById(int id) {
//        return modelMapper.map(dao.findById(id), ProductsCategoryDTO.class);
//    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> findByParent(Integer parent) {
        return modelMapper.mapListsEntityToDTO(dao.findByParent(parent), ProductsCategoryDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> findSlaveNodesById(Integer id) {
        ProductsCategory productsCategory = dao.findById(id);
        return modelMapper.mapListsEntityToDTO(dao.findSlaveNodes(productsCategory.getLeftKey(), productsCategory.getRightKey()), ProductsCategoryDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> findParentBranchById(Integer id) {
        ProductsCategory productsCategory = dao.findById(id);
        return modelMapper.mapListsEntityToDTO(dao.findParentBranch(productsCategory.getLeftKey(), productsCategory.getRightKey()), ProductsCategoryDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> findCurrentBranchById(Integer id) {
        ProductsCategory productsCategory = dao.findById(id);
        return modelMapper.mapListsEntityToDTO(dao.findCurrentBranch(productsCategory.getLeftKey(), productsCategory.getRightKey()), ProductsCategoryDTO.class);
    }


//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public List<ProductsCategoryDTO> findAll() {
////        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
////        modelMapper.typeMap(ProductsCategory.class, ProductsCategoryDTO.class)
////                .addMappings(m -> m.map(src -> src.getParent().getId(), ProductsCategoryDTO::setParent));
//        return modelMapper.mapListsEntityToDTO(dao.findAll(), ProductsCategoryDTO.class);
//    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductsCategoryDTO productsCategoryDTO) {

        ProductsCategory parentProductsCategory = dao.findById(productsCategoryDTO.getParent());

        dao.updateBranchesBeforeCreate(parentProductsCategory.getRightKey());

        productsCategoryDTO.setLeftKey(parentProductsCategory.getRightKey());
        productsCategoryDTO.setRightKey(parentProductsCategory.getRightKey() + 1);
        productsCategoryDTO.setLevel(parentProductsCategory.getLevel() + 1);
        dao.create(modelMapper.map(productsCategoryDTO, ProductsCategory.class));
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        ProductsCategory roductsCategory = dao.findById(id);
        dao.deleteSlaveNodes(roductsCategory.getLeftKey(), roductsCategory.getRightKey());
        dao.updateBranchesAfterDelete(roductsCategory.getLeftKey(), roductsCategory.getRightKey());
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> checkLeftMoreRight() {
        return modelMapper.mapListsEntityToDTO(dao.selectLeftMoreRight(), ProductsCategoryDTO.class);
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
        return modelMapper.mapListsEntityToDTO(dao.selectByModRightLeft(), ProductsCategoryDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> checkModLeftLevel() {
        return modelMapper.mapListsEntityToDTO(dao.selectByModLeftLevel(), ProductsCategoryDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductsCategoryDTO> checkNotUniqueNods() {
        return modelMapper.mapListsEntityToDTO(dao.selectNotUniqueNods(), ProductsCategoryDTO.class);
    }

}
