package com.web.shop.model.product;

import com.web.shop.model.enums.Sorting;
import com.web.shop.model.order.OrderProduct;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.util.List;

@StaticMetamodel(Product.class)
public class Product_ {
    public static volatile SingularAttribute<Product,Integer> id;
    public static volatile SingularAttribute<Product,String> name;
    public static volatile SingularAttribute<Product,String> characterCode;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile SingularAttribute<Product,BigDecimal> priceFilterMin;
    public static volatile SingularAttribute<Product,BigDecimal> priceFilterMax;
    public static volatile SingularAttribute<Product, Sorting> sort;
    public static volatile SingularAttribute<Product, Integer> stockQuantity;
    public static volatile SingularAttribute<Product, ProductCategory> productCategory;
    public static volatile SingularAttribute<Product, List<ProductCharacteristic>> productCharacteristicList;
    public static volatile SingularAttribute<Product, List<OrderProduct>> orderProductList;
}
