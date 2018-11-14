package com.web.shop.service.transact.products;

import com.web.shop.dao.orders.OrderDao;
import com.web.shop.dao.products.ProductDao;
import com.web.shop.dao.products.ProductsCategoryDao;
import com.web.shop.dao.users.AddressDao;
import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.orders.OrderProductDTO;
import com.web.shop.dto.products.ProductCharacteristicTypeDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.model.enums.OrderStatusEnum;
import com.web.shop.model.enums.PaymentStatusEnum;
import com.web.shop.model.orders.Order;
import com.web.shop.model.orders.OrderProduct;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("productServiceTransact")
public class ProductServiceTransactImpl extends GenericServiceTransactImpl<ProductDTO, Integer, ProductDao, Product> implements ProductService {

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductDTO productDTO) {

        Product product = modelMapper.map(productDTO, Product.class);
        dao.create(product);
        productDTO.setId(product.getId());
    }

}
