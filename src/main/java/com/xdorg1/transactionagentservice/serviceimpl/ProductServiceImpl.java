package com.xdorg1.transactionagentservice.serviceimpl;

import com.xdorg1.transactionagentservice.model.Product;
import com.xdorg1.transactionagentservice.model.ProductMapper;
import com.xdorg1.transactionagentservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getProductList(){

        logger.info("getProductList called.");

        return productMapper.getProductList();

    }

}
