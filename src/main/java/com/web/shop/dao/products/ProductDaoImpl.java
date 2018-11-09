package com.web.shop.dao.products;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.products.Product;
import org.springframework.stereotype.Repository;

@Repository("productsDao")
public class ProductDaoImpl  extends GenericDaoImpl<Product, Integer> implements ProductDao {

}
