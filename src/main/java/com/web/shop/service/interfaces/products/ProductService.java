package com.web.shop.service.interfaces.products;

import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.orders.OrderProductDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.dto.products.ProductsCategoryDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.model.products.Product;
import com.web.shop.service.GenericService;

import java.util.List;

public interface ProductService extends GenericService<ProductDTO, Integer> {

//    ProductDTO findById(Integer id);
//
//    void create(ProductDTO productCharacteristicDTO);
//
//    void delete(Integer id);
//
//    List<ProductDTO> findAll();

    List<ProductDTO> checkExistInStock(OrderDTO orderSession, OrderDTO orderDTO, UserDTO userDTO);

}
