package com.web.shop.dao.product;

import com.web.shop.dao.GenericDaoImpl;
import com.web.shop.model.enums.CharacteristicType;
import com.web.shop.model.order.OrderProduct;
import com.web.shop.model.product.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.criteria.internal.predicate.BetweenPredicate;
import org.hibernate.query.criteria.internal.predicate.ComparisonPredicate;
import org.hibernate.query.criteria.internal.predicate.ExistsPredicate;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends GenericDaoImpl<Product, Integer> implements ProductDao {
    @Override
    public List<Product> findAllByIds(List<OrderProduct> orderProducts) {

        StringBuffer ids = new StringBuffer();
        orderProducts.forEach(
                (i) -> ids.append("," + i.getProduct().getId())
        );
        ids.deleteCharAt(0);
        try {
//            getEntityManager().find(id, Product.class, LockModeType.PESSIMISTIC_WRITE);
            return (List<Product>) getEntityManager()
                    .createQuery("SELECT u FROM Product u WHERE u.id IN (" + ids + ") AND u.stockQuantity < 1 FOR UPDATE")
                    .getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Product findByIdForUpdate(Integer id) {
        return getEntityManager().find(Product.class, id, LockModeType.PESSIMISTIC_WRITE);
    }

    @Override
    public void setCategoryToNull(Integer categoryId) {
        getEntityManager()
                .createQuery("UPDATE Product u " +
                        "SET u.productCategory.id = 0 " +
                        "WHERE u.productCategory.id = :categoryId")
                .setParameter("categoryId", categoryId)
                .executeUpdate();
    }

    @Override
    public List<Product> findByFilter(Product product) {
        try {

            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
            criteriaQuery.distinct(true);
            Root<Product> productRoot = criteriaQuery.from(Product.class);
//            Root<ProductCharacteristic> productCharacteristicJoin = criteriaQuery.from(ProductCharacteristic.class);

            Join<Product, ProductCategory> productCategoryJoin = productRoot.join("productCategory", JoinType.LEFT);
//            productCategoryJoin.on(criteriaBuilder.equal(productCategoryJoin.get("id"), productRoot.get("productCategory")));

            Join<Product, ProductCharacteristic> productCharacteristicJoin = productRoot.join("productCharacteristicList", JoinType.LEFT);
//            productCharacteristicJoin.on(criteriaBuilder.equal(productCharacteristicJoin.get("product"), productRoot.get("id")));

            Join<Product, ProductCharacteristicCheckboxValue> productProductCharacteristicCheckboxValueJoin = productCharacteristicJoin.join("productCharacteristicCheckboxValueList", JoinType.LEFT);
//            productProductCharacteristicCheckboxValueJoin.on(criteriaBuilder.equal(productProductCharacteristicCheckboxValueJoin.get("productCharacteristic"), productCharacteristicJoin.get("id")));

            List<Predicate> predicates = new ArrayList<>();


//            predicates.add(criteriaBuilder.equal(productCharacteristicJoin.get("product"), productRoot.get("id")));

//            predicates.add(cb.ge(productRoot.get("priceFilterMin"), product.getPriceFilterMin()));


//            Criteria criteria = createEntityCriteria();
//            criteria.add(Restrictions.le("", product.getPriceFilterMax()));

//// Create CriteriaBuilder
//            CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
//
//// Create CriteriaQuery
//            CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
//            Criteria criteria = getSession().createCriteria(Product.class);


            if (product.getPriceFilterMax() != null) {
                predicates.add(criteriaBuilder.le(productRoot.get("price"), product.getPriceFilterMax()));
            }
            if (product.getPriceFilterMin() != null) {
                predicates.add(criteriaBuilder.ge(productRoot.get("price"), product.getPriceFilterMin()));
            }
            if (product.getName() != null) {
                predicates.add(criteriaBuilder.like(productRoot.get("name"), "%" + product.getName() + "%"));
            }
            if (product.getProductCategory().getLeftKey() != null && product.getProductCategory().getRightKey() != null) {
                predicates.add(criteriaBuilder.le(productCategoryJoin.get("leftKey"), product.getProductCategory().getLeftKey()));
                predicates.add(criteriaBuilder.ge(productCategoryJoin.get("rightKey"), product.getProductCategory().getRightKey()));
            }

            Integer counterCharacteristic = 0;

            Predicate disjunctionPredicate = criteriaBuilder.disjunction();
            for (ProductCharacteristic productCharacteristic : product.getProductCharacteristicList()) {
                Predicate conjunctionPredicate = criteriaBuilder.equal(productCharacteristicJoin.get("productCharacteristicType"), productCharacteristic.getProductCharacteristicType().getId());

                switch (productCharacteristic.getProductCharacteristicType().getCharacteristicType()) {
                    case BOOLEAN:
                        if (productCharacteristic.getBooleanCharacteristicValue() != null){
                            counterCharacteristic++;
                            conjunctionPredicate = criteriaBuilder.and(
                                    conjunctionPredicate,
                                    criteriaBuilder.equal(productCharacteristicJoin.get("booleanCharacteristicValue"), productCharacteristic.getBooleanCharacteristicValue())
                            );
                        }
                        break;
                    case INTEGER:
                        if (productCharacteristic.getIntegerCharacteristicFilterMin() != null){
                            conjunctionPredicate = criteriaBuilder.and(
                                    conjunctionPredicate,
                                    criteriaBuilder.ge(productCharacteristicJoin.get("integerCharacteristicValue"), productCharacteristic.getIntegerCharacteristicFilterMin())
                            );
                        }
                        if (productCharacteristic.getIntegerCharacteristicFilterMax() != null){
                            conjunctionPredicate = criteriaBuilder.and(
                                    conjunctionPredicate,
                                    criteriaBuilder.le(productCharacteristicJoin.get("integerCharacteristicValue"), productCharacteristic.getIntegerCharacteristicFilterMax())
                            );
                        }
                        if(conjunctionPredicate.getExpressions().size()>1)
                            counterCharacteristic++;
                        break;
                    case STRING:
                        if (productCharacteristic.getStringCharacteristicValue() != null && !productCharacteristic.getStringCharacteristicValue().equalsIgnoreCase("")){
                            counterCharacteristic++;
                            conjunctionPredicate = criteriaBuilder.and(
                                    conjunctionPredicate,
                                    criteriaBuilder.like(productCharacteristicJoin.get("stringCharacteristicValue"), productCharacteristic.getStringCharacteristicValue())
                            );
                        }
                        break;
                    case DOUBLE:
                        if (productCharacteristic.getDoubleCharacteristicFilterMin() != null){
                            conjunctionPredicate = criteriaBuilder.and(
                                    conjunctionPredicate,
                                    criteriaBuilder.ge(productCharacteristicJoin.get("doubleCharacteristicValue"), productCharacteristic.getDoubleCharacteristicFilterMin())
                            );
                        }
                        if (productCharacteristic.getDoubleCharacteristicFilterMax() != null){
                            conjunctionPredicate = criteriaBuilder.and(
                                    conjunctionPredicate,
                                    criteriaBuilder.le(productCharacteristicJoin.get("doubleCharacteristicValue"), productCharacteristic.getDoubleCharacteristicFilterMax())
                            );
                        }
                        if(conjunctionPredicate.getExpressions().size()>1)
                            counterCharacteristic++;
                        break;
                    case CHECKBOX:
                        for (ProductCharacteristicCheckboxValue productCharacteristicCheckboxValue : productCharacteristic.getProductCharacteristicCheckboxValueList()) {

                            if (productCharacteristicCheckboxValue.getProductCharacteristicCheckboxField().getId() != null){
                                conjunctionPredicate = criteriaBuilder.and(
                                        conjunctionPredicate,
                                        criteriaBuilder.equal(productProductCharacteristicCheckboxValueJoin.get("productCharacteristicCheckboxField"), productCharacteristicCheckboxValue.getProductCharacteristicCheckboxField().getId())
                                );
                            }

                        }
                        if(conjunctionPredicate.getExpressions().size()>1)
                            counterCharacteristic++;
                        break;
                    default:
                }
                if (conjunctionPredicate.getExpressions().size() > 1)
                    if (disjunctionPredicate.getExpressions().size() > 0)
                        disjunctionPredicate = criteriaBuilder.or(
                                disjunctionPredicate,
                                conjunctionPredicate
                        );
                    else
                        disjunctionPredicate = criteriaBuilder.and(conjunctionPredicate);
            }
            if (disjunctionPredicate.getExpressions().size() > 0)
                predicates.add(disjunctionPredicate);

            criteriaQuery.select(productRoot).where(criteriaBuilder.and(predicates.toArray(new Predicate[]{})));
            criteriaQuery.groupBy(productRoot.get("id"));
            if(counterCharacteristic == 0)
                counterCharacteristic = product.getProductCategory().getProductCharacteristicTypeList().size() + 1;
            criteriaQuery.having(criteriaBuilder.equal(criteriaBuilder.count(productRoot), counterCharacteristic));

            switch (product.getSort()) {
                case ASC_NAME:
                case ASC_PRICE:
                    criteriaQuery.orderBy(criteriaBuilder.asc(productRoot.get(product.getSort().getSorting())));
                    break;
                case DESC_NAME:
                case DESC_PRICE:
                    criteriaQuery.orderBy(criteriaBuilder.desc(productRoot.get(product.getSort().getSorting())));
                    break;
                default:
            }

            TypedQuery<Product> productTypedQuery = getEntityManager().createQuery(criteriaQuery);
            List<Product> productList = productTypedQuery.getResultList();
            if (productList.size() == 0)
                return new ArrayList<Product>();
            return productList;


        } catch (NoResultException ex) {
            return null;
        }
    }

//
//    @Override
//    public void create(Product entity) {
//        getEntityManager().merge(entity);
//    }
}
