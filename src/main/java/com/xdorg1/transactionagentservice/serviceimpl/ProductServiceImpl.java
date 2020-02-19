package com.xdorg1.transactionagentservice.serviceimpl;

import com.xdorg1.transactionagentservice.model.Product;
import com.xdorg1.transactionagentservice.model.ProductMapper;
import com.xdorg1.transactionagentservice.model.ProductPriceUnit;
import com.xdorg1.transactionagentservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PriceServiceHelper priceServiceHelper;

    public List<Product> getProductListWithoutFreshPrice(){

        logger.info("getProductList called.");

        return productMapper.getProductList();

    }

    public List<Product> getProductList(){

        List<Product> productList = getProductListWithoutFreshPrice();

        //prepare the product list for price update
        logger.info("product list is " + productList);
        List<ProductPriceUnit> ppuList = new LinkedList<ProductPriceUnit>();
        for(Product prod: productList){
            logger.info("Product with id " + prod.getProduct_id() + " will be checked, isDynamicPrice is " + prod.isDynamicPrice());
            if (prod.isDynamicPrice()) {
                ProductPriceUnit unit = new ProductPriceUnit();
                unit.ProductId = prod.getProduct_id();
                unit.ProductName = prod.getProduct_name();
                ppuList.add(unit);
                logger.info("ProductPriceUnit: " + unit + " added.");
            }
        }

        logger.info("ProductPriceUnit list is: " + ppuList);
        logger.info("the size of the ProductPriceUnit list is: " + ppuList.size());

        if(ppuList.size() > 0) {

            //get the price update from price service and update back to the original product list
            List<ProductPriceUnit> updatedList = priceServiceHelper.refreshProductPriceList(ppuList);

            for (ProductPriceUnit ppu : updatedList) {
                for (Product prod : productList) {
                    if (prod.getProduct_id() == ppu.ProductId) prod.setUnit_price(ppu.Price);
                }
            }
        }

        return productList;

    }

    public Product refreshSingleProductPrice(int product_id, String product_name){

        Product prod = productMapper.getProduct(product_id, product_name);

        if (prod != null && prod.isDynamicPrice()){
            ProductPriceUnit ppu = priceServiceHelper.getSingleProductPrice(product_id, product_name);
            prod.setUnit_price(ppu.Price);
        }

        return prod;

    }

}
