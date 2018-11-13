package com.web.shop.service.front.products;

import com.web.shop.dto.orders.OrderDTO;
import com.web.shop.dto.products.ProductDTO;
import com.web.shop.dto.users.UserDTO;
import com.web.shop.exceptions.GlobalCustomException;
import com.web.shop.exceptions.NoProductsInStockException;
import com.web.shop.service.interfaces.products.ProductService;
import com.web.shop.service.interfaces.products.ProductsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceFront implements ProductService {


    @Autowired
    ProductService productService;

    @Override
    public ProductDTO findById(Integer id) {
        return productService.findById(id);
    }

    @Override
    public void create(ProductDTO productDTO) throws GlobalCustomException {
        productService.create(productDTO);
    }

    @Override
    public void delete(Integer id) throws GlobalCustomException {
        productService.delete(id);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    public List<ProductDTO> checkExistInStock(OrderDTO orderSession, OrderDTO orderDTO, UserDTO userDTO) {
        orderSession.setAddress(orderDTO.getAddress());
        orderSession.setDeliveryEnum(orderDTO.getDeliveryEnum());
        orderSession.setPaymentEnum(orderDTO.getPaymentEnum());

        List<ProductDTO> productDTO = productService.checkExistInStock(orderSession, orderDTO, userDTO);

        if(productDTO != null){
            return productDTO;
//            throw new NoProductsInStockException("No product in stock", productDTO);
        }else{
            return null;
        }
    }
}
