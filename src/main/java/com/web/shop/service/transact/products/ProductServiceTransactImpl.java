package com.web.shop.service.transact.products;

import com.web.shop.dao.orders.OrderDao;
import com.web.shop.dao.products.ProductDao;
import com.web.shop.dao.products.ProductsCategoryDao;
import com.web.shop.dao.users.AddressDao;
import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.products.ProductCharacteristicTypeDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.model.enums.OrderStatusEnum;
import com.web.shop.model.enums.PaymentStatusEnum;
import com.web.shop.model.orders.Order;
import com.web.shop.model.products.Product;
import com.web.shop.model.products.ProductCharacteristicType;
import com.web.shop.model.products.ProductsCategory;
import com.web.shop.model.users.User;
import com.web.shop.service.interfaces.products.ProductService;
import com.web.shop.service.transact.GenericServiceTransactImpl;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("productServiceTransact")
public class ProductServiceTransactImpl extends GenericServiceTransactImpl<ProductDTO, Integer, ProductDao, Product> implements ProductService {

    @Autowired
    ProductsCategoryDao productsCategoryDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    AddressDao addressDao;
//    @Autowired
//    CustomModelMapper<ProductDTO, Product> modelMapper;
//
//
//    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//    public ProductDTO findById(int id) {
//        return modelMapper.map(dao.findById(id), ProductDTO.class);
//    }
//
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductDTO productDTO) {
//        if(productDTO.getProductsCategory() == null)
//            productDTO.setProductsCategory(new ProductsCategoryDTO(productDTO.getProductsCategoryId()));
//            productDTO.setProductsCategory(modelMapper.map(productsCategoryDao.findById(productDTO.getProductsCategoryId()), ProductsCategoryDTO.class));
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        modelMapper.typeMap(ProductDTO.class, Product.class)
//                .addMappings(m -> m.map(src -> src.getProductsCategory(), Product::setProductsCategory));

        Product product = modelMapper.map(productDTO, Product.class);
        dao.create(product);
        productDTO.setId(product.getId());
    }
//
//    public void delete(Integer id) {
//        dao.deleteById(id);
//    }
//
//    @Override
//    public List<ProductDTO> findAll() {
//        return modelMapper.mapListsEntityToDTO(dao.findAll(), ProductDTO.class);
//    }


    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<ProductDTO> checkExistInStock(OrderDTO orderSession, OrderDTO orderDTO, UserDTO userDTO) {
        Order order = modelMapper.map(orderSession, Order.class);
        List<Product> products = new ArrayList<>();
        products.addAll(dao.findAllByIds(order.getOrderProducts()));

        if(products != null && products.size() != 0)
            return modelMapper.mapListsEntityToDTO((List<Product>)products, ProductDTO.class);

        order.getOrderProducts().forEach((i)->{
            i.getProduct().setStockQuantity(i.getProduct().getStockQuantity() - 1);
            dao.update(i.getProduct());
        });

        order.setUser(modelMapper.map(userDTO, User.class));
        order.setOrderStatusEnum(OrderStatusEnum.AWAITING_PAID);
        order.setPaymentStatusEnum(PaymentStatusEnum.AWAITING);
        order.getAddress().setUser(order.getUser());
        addressDao.create(order.getAddress());

        orderDao.create(order);

        return null;
    }
}
