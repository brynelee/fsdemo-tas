package com.xdorg1.transactionagentservice.controller;

import com.xdorg1.transactionagentservice.model.Product;
import com.xdorg1.transactionagentservice.model.ProductPriceUnit;
import com.xdorg1.transactionagentservice.service.ProductService;
import com.xdorg1.transactionagentservice.serviceimpl.PriceServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.util.*;

@RestController
public class ProductServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private PriceServiceHelper priceServiceHelper;

    @RequestMapping("/tas/products")
    public List<Product> products(@RequestParam(value="product_id", required = false) Integer product_id,
                                  @RequestParam(value="product_name", required = false) String product_name)
    {
        List<Product> productList;

        if (product_id == null || product_name == null) {

            logger.info("/tas/products without parameters access ...");
            // no paremeters provided, will return the product list

            productList = productService.getProductList();

        }else{
            logger.info("/tas/products with product_id and product_name access ...");
            // respond with the single product information
            Product prod = productService.refreshSingleProductPrice(product_id, product_name);
            productList = new LinkedList<Product>();
            productList.add(prod);
        }

        return productList;

    }

    //for test purpose
    @RequestMapping("/tas/prices")
    public List<ProductPriceUnit> refreshAll(){

        return priceServiceHelper.getAllProductPrice();
    }

}
