package com.xdorg1.transactionagentservice.controller;

import com.xdorg1.transactionagentservice.model.Product;
import com.xdorg1.transactionagentservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class ProductServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("/tas/getproductlist")
    public List<Product> getProductList()
    {
        List<Product> productList = productService.getProductList();
        logger.info("product list is " + productList);
        Iterator<Product> it = productList.iterator();
        while (!it.hasNext()){
            Product product = it.next();
            logger.info("the product id " + product.getProduct_id() + " and product name is " + product.getProduct_name());
        }
        return productList;

    }
}
