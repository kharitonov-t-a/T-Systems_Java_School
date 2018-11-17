package com.web.shop.controler.product;

import com.web.shop.dto.product.ProductCategoryDTO;
import com.web.shop.dto.product.ProductDTO;
import com.web.shop.service.interfaces.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
//@SessionAttributes({"listProductsKey", "listProducts"})
@RequestMapping("/")
public class ListProductController {

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping(value = {"/listProduct/{id}/{page}"}, method = RequestMethod.GET)
    public String listProduct(@PathVariable Integer id, @PathVariable Integer page, ModelMap model, HttpSession httpSession) {

        List<ProductDTO> productDTOList = new ArrayList<>();
        Integer listProductsKey = (Integer) httpSession.getAttribute("listProductsKey");

        if (listProductsKey == null || listProductsKey != id) {
            List<ProductCategoryDTO> productCategoryDTOList = productCategoryService.findSlaveNodesById(id);
            for (ProductCategoryDTO productCategoryDTO : productCategoryDTOList) {
                productDTOList.addAll(productCategoryDTO.getProductList());
            }
            httpSession.setAttribute("listProductsKey", id);
            httpSession.setAttribute("listProducts", productDTOList);
        }else{
            productDTOList.addAll((List<ProductDTO>) httpSession.getAttribute("listProducts"));
        }

        Integer rightNumber = productDTOList.size() < (page*12 + 12) ? productDTOList.size() : (page*12 + 12);

        model.addAttribute("listProductsDTO", productDTOList.subList(page*12, rightNumber));

        return "catalog/listProduct";
    }

//    @RequestMapping(value = {"/listP/{id}/{page}"}, method = RequestMethod.GET)
//    public String listP(@PathVariable Integer id, @PathVariable Integer page, ModelMap model, HttpSession httpSession) {
//
//        List<ProductDTO> productDTOList = new ArrayList<>();
//        if(httpSession.isNew() || httpSession.getAttribute("listProductsKey") == null || !httpSession.getAttribute("listProductsKey").equals(id)) {
//            List<ProductCategoryDTO> productsCategoryDTOList = productCategoryService.findSlaveNodesById(id);
//            for (ProductCategoryDTO productsCategoryDTO:productsCategoryDTOList) {
//                productDTOList.addAll(productsCategoryDTO.getProductList());
//            }
//
//            httpSession.setAttribute("listProductsKey", id);
//            httpSession.setAttribute("listProducts", productDTOList);
//        }else {
//            productDTOList.addAll((List<ProductDTO>) httpSession.getAttribute("listProducts"));
//        }
//
//        Integer rightNumber = productDTOList.size() < (page*12 + 12) ? productDTOList.size() : (page*12 + 12);
//
//        model.addAttribute("listProductsDTO", productDTOList.subList(page*12, rightNumber));
//
//        return "catalog/listP";
//    }


}
