package com.web.shop.controler.product;

import com.web.shop.dto.product.ProductCategoryDTO;
import com.web.shop.dto.product.ProductDTO;
import com.web.shop.model.enums.Sorting;
import com.web.shop.model.product.ProductCategory;
import com.web.shop.service.interfaces.product.ProductCategoryService;
import com.web.shop.service.interfaces.product.ProductCharacteristicTypeService;
import com.web.shop.service.interfaces.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
//@SessionAttributes({"listProductsKey", "listProducts"})
@RequestMapping("/catalog")
public class CatalogProductController {

    @Autowired
    ProductCategoryService productCategoryService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductCharacteristicTypeService productCharacteristicTypeService;

    @RequestMapping(value = {"/{categoryId}"}, method = RequestMethod.GET)
    public String listProduct(@PathVariable Integer categoryId, ModelMap model, HttpSession httpSession) {

        Integer page = 0;

        ProductDTO productDTO = new ProductDTO();
        List<ProductDTO> productDTOList = new ArrayList<>();

        productDTO.setProductCategory(productCategoryService.findById(categoryId));

        productDTOList = productService.findByFilter(productDTO);
        httpSession.setAttribute("listProductsKey", categoryId);
        httpSession.setAttribute("listProducts", productDTOList);

        Integer rightNumber = productDTOList.size() < (page*12 + 12) ? productDTOList.size() : (page*12 + 12);

        Integer countPage = productDTOList.size() / 12 + 1;

        model.addAttribute("listProductsDTO", productDTOList.subList(page*12, rightNumber));
        model.addAttribute("ProductCharacteristicTypeDTOList", productCharacteristicTypeService.findByCatalogId(Integer.valueOf(categoryId)));
        model.addAttribute("productDTO", productDTO);
        model.addAttribute("countPage", countPage);
        model.addAttribute("currentPage", page + 1);

        return "catalog/catalogProduct";
    }

    @RequestMapping(value = {"/{categoryId}/{page}"}, method = RequestMethod.GET)
    public String listProduct(@PathVariable Integer categoryId, @PathVariable Integer page, ModelMap model, HttpSession httpSession) {

        page--;

        Integer listProductsKey = (Integer) httpSession.getAttribute("listProductsKey");

        ProductDTO productDTO = new ProductDTO();
        List<ProductDTO> productDTOList = new ArrayList<>();

        productDTO.setProductCategory(productCategoryService.findById(categoryId));

        if (listProductsKey == null || listProductsKey != categoryId) {
            productDTO.setSort(Sorting.ASC_NAME);
            productDTOList = productService.findByFilter(productDTO);
            httpSession.setAttribute("listProductsKey", categoryId);
            httpSession.setAttribute("listProducts", productDTOList);
            model.addAttribute("changeCategory", "changeCategory");
            page = 0;
        }else{
            productDTOList.addAll((List<ProductDTO>) httpSession.getAttribute("listProducts"));
        }

        Integer rightNumber = productDTOList.size() < (page*12 + 12) ? productDTOList.size() : (page*12 + 12);

        Integer countPage = productDTOList.size() / 12 + 1;

        model.addAttribute("listProductsDTO", productDTOList.subList(page*12, rightNumber));
        model.addAttribute("ProductCharacteristicTypeDTOList", productCharacteristicTypeService.findByCatalogId(Integer.valueOf(categoryId)));
        model.addAttribute("productDTO", productDTO);
        model.addAttribute("countPage", countPage);
        model.addAttribute("currentPage", page + 1);

        return "catalog/catalogProduct";
    }

    @RequestMapping(value = {"/{categoryId}", "/{categoryId}/{page}"}, method = RequestMethod.POST)
    public String filterListProduct(ProductDTO productDTO, ModelMap model, BindingResult result, HttpSession httpSession) {

        if(result.hasErrors()) {
            return "catalog/catalogProduct";
        }

        Integer page = 0;

        productDTO.setProductCategory(productCategoryService.findById(productDTO.getProductCategory().getId()));

        List<ProductDTO> productDTOList = productDTOList = productService.findByFilter(productDTO);
        httpSession.setAttribute("listProducts", productDTOList);

        Integer rightNumber = productDTOList.size() < (page*12 + 12) ? productDTOList.size() : (page*12 + 12);

        Integer countPage = productDTOList.size() / 12 + 1;

        model.addAttribute("listProductsDTO", productDTOList.subList(page*12, rightNumber));
        model.addAttribute("ProductCharacteristicTypeDTOList", productCharacteristicTypeService.findByCatalogId(productDTO.getProductCategory().getId()));
        model.addAttribute("productDTO", productDTO);
        model.addAttribute("countPage", countPage);
        model.addAttribute("currentPage", page + 1);

        return "catalog/catalogProduct";
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
