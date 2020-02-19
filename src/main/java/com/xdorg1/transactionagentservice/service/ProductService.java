package com.xdorg1.transactionagentservice.service;

import com.xdorg1.transactionagentservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getProductListWithoutFreshPrice();
    List<Product> getProductList();
    Product refreshSingleProductPrice(int product_id, String product_name);
}
