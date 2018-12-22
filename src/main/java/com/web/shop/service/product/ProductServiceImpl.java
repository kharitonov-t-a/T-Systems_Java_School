package com.web.shop.service.product;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.web.shop.converter.CustomModelMapper;
import com.web.shop.dao.interfaces.product.*;
import com.web.shop.dto.product.ProductCharacteristicDTO;
import com.web.shop.dto.product.ProductDTO;
import com.web.shop.jms.JMSService;
import com.web.shop.model.enums.CharacteristicType;
import com.web.shop.model.product.Product;
import com.web.shop.model.product.ProductCharacteristic;
import com.web.shop.model.product.ProductCharacteristicCheckboxValue;
import com.web.shop.service.interfaces.product.ProductService;
import com.web.shop.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service("productService")
public class ProductServiceImpl extends GenericServiceImpl<ProductDTO, Integer, ProductDao, Product> implements ProductService {

    @Autowired
    ProductService productService;
    @Autowired
    ProductCategoryDao productCategoryDao;
    @Autowired
    ProductCharacteristicTypeDao productCharacteristicTypeDao;
    @Autowired
    ProductCharacteristicDao productCharacteristicDao;
    @Autowired
    ProductCharacteristicCheckboxFieldDao productCharacteristicCheckboxFieldDao;
    @Autowired
    ProductCharacteristicCheckboxValueDao productCharacteristicCheckboxValueDao;

    @Autowired
    CustomModelMapper<ProductCharacteristic, ProductCharacteristicDTO> modelMapperCharacteristic;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(ProductDTO productDTO) {

//        AWSCredentials credentials = new BasicAWSCredentials(
//                "wSl1eF2SyDCp45KQLZwhgd1v8V9p2RKidaJTQgMr",
//                "VJ!|H3!Qk2YG"
//        );
//        AmazonS3 s3client = AmazonS3ClientBuilder
//                .standard()
//                .withCredentials(new AWSStaticCredentialsProvider(credentials))
//                .withRegion(Regions.DEFAULT_REGION)
//                .build();
//        s3client.createBucket(bucketName);

        productDTO.getProductCharacteristicList().removeIf((i)->i.getProductCharacteristicType() == null);
        productDTO.getProductCharacteristicList().forEach((i)->i.getProductCharacteristicCheckboxValueList().removeIf((l)->l.getProductCharacteristicCheckboxField() == null));
        productDTO.getProductCharacteristicList().forEach((i)->i.getProductCharacteristicCheckboxValueList().removeIf((l)->l.getProductCharacteristicCheckboxField().getId() == null));

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Product product = modelMapper.map(productDTO, Product.class);

        product.getProductCharacteristicList().forEach((i)->i.setProduct(product));
        product.getProductCharacteristicList().forEach((i)->i.setProductCharacteristicType(productCharacteristicTypeDao.findById(i.getProductCharacteristicType().getId())));
        product.getProductCharacteristicList().forEach((i->i.getProductCharacteristicCheckboxValueList().forEach((l)->l.setProductCharacteristicCheckboxField(productCharacteristicCheckboxFieldDao.findById(l.getProductCharacteristicCheckboxField().getId())))));
        product.getProductCharacteristicList().forEach((i->i.getProductCharacteristicCheckboxValueList().forEach((l)->l.setProductCharacteristic(i))));
        product.setProductCategory(productCategoryDao.findById(product.getProductCategory().getId()));

        dao.create(product);

        JMSService.sendQueue();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductDTO> findAll() {
        List<Product> productDTOList = dao.findAll();
        productDTOList.sort(Comparator.comparing(o -> o.getProductCategory().getLeftKey()));
        return  modelMapper.mapListsEntityToDTO(productDTOList, ProductDTO.class);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<ProductDTO> findByFilter(ProductDTO productDTO) {

        Product product = modelMapper.map(productDTO, Product.class);

        if(product.getProductCharacteristicList().size() > 0)
            product.getProductCharacteristicList().forEach(productCharacteristic -> productCharacteristic.setProductCharacteristicType(productCharacteristicTypeDao.findById(productCharacteristic.getProductCharacteristicType().getId())));
//        else
//            product.setCountSlaveCharacteristics(productCharacteristicTypeDao.findCountByCategory(product.getProductCategory()));
        List<Product> productDTOList = dao.findByFilter(product);
        return  modelMapper.mapListsEntityToDTO(productDTOList, ProductDTO.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(ProductDTO productDTO) {
        productDTO.getProductCharacteristicList().removeIf((i)->i.getProductCharacteristicType() == null);
        productDTO.getProductCharacteristicList().forEach((i)->i.getProductCharacteristicCheckboxValueList().removeIf((l)->l.getProductCharacteristicCheckboxField() == null));
        productDTO.getProductCharacteristicList().forEach((i)->i.getProductCharacteristicCheckboxValueList().removeIf((l)->l.getProductCharacteristicCheckboxField().getId() == null));

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Product product = modelMapper.map(productDTO, Product.class);
        Product productExist = dao.findById(product.getId());

        product.getProductCharacteristicList().forEach((i)->i.setProduct(product));
        product.getProductCharacteristicList().forEach((i)->i.setProductCharacteristicType(productCharacteristicTypeDao.findById(i.getProductCharacteristicType().getId())));
        product.getProductCharacteristicList().forEach((i->i.getProductCharacteristicCheckboxValueList().forEach((l)->l.setProductCharacteristicCheckboxField(productCharacteristicCheckboxFieldDao.findById(l.getProductCharacteristicCheckboxField().getId())))));
        product.getProductCharacteristicList().forEach((i->i.getProductCharacteristicCheckboxValueList().forEach((l)->l.setProductCharacteristic(i))));

//        Product productExist = dao.findById(product.getId());

        if(productExist.getProductCategory().getId() != product.getProductCategory().getId()){
            productExist.getProductCharacteristicList().forEach((i)->productCharacteristicDao.deleteById(i.getId()));
        }else{
            for (ProductCharacteristic productCharacteristic:product.getProductCharacteristicList()) {
                for (ProductCharacteristic productCharacteristicExist:productExist.getProductCharacteristicList()) {
                    if(productCharacteristic.getId() == productCharacteristicExist.getId()){

                        if(productCharacteristic.getProductCharacteristicType().getCharacteristicType() == CharacteristicType.CHECKBOX){

                            for (ProductCharacteristicCheckboxValue productCharacteristicCheckboxValueExist:productCharacteristicExist.getProductCharacteristicCheckboxValueList()) {
                                boolean flagExistProductCharacteristicCheckboxValue = false;
                                for (ProductCharacteristicCheckboxValue productCharacteristicCheckboxValue:productCharacteristic.getProductCharacteristicCheckboxValueList()) {
                                    if(productCharacteristicCheckboxValue.getId() == productCharacteristicCheckboxValueExist.getId()){
                                        flagExistProductCharacteristicCheckboxValue = true;
                                        break;
                                    }
                                }
                                if(flagExistProductCharacteristicCheckboxValue == false)
                                    productCharacteristicCheckboxValueDao.deleteById(productCharacteristicCheckboxValueExist.getId());
                            }
                        }
                        break;
                    }
                }
            }

        }

        dao.update(product);


    }

}
