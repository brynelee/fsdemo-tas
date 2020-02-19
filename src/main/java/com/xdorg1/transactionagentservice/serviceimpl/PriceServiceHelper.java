package com.xdorg1.transactionagentservice.serviceimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xdorg1.transactionagentservice.model.ProductPriceUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

@Component
public class PriceServiceHelper {

    private static final Logger logger = LoggerFactory.getLogger(PriceServiceHelper.class);

    @Autowired
    RestTemplate restTemplate;

    private static final String PRICESERVER = "http://fsdemo-priceservice:8083";

    public ProductPriceUnit getSingleProductPrice(int product_id, String product_name){

        String priceServerUrl = PRICESERVER + "/priceservice/prices?productid={productid}&productname={productname}";

        Map<String, String> urlVariables = new HashMap<String, String>();
        urlVariables.put("productid", Integer.toString(product_id));
        urlVariables.put("productname", product_name);

        return restTemplate.getForObject(priceServerUrl, ProductPriceUnit.class, urlVariables);
    }

    public List<ProductPriceUnit> refreshProductPriceList(List<ProductPriceUnit> ppuList){

        String priceServerUrl = PRICESERVER + "/priceservice/prices";

        ProductPriceUnit[] updatedPPULArray = restTemplate.postForObject(priceServerUrl, ppuList, ProductPriceUnit[].class);

        logger.info("Got POST response from /priceservice/prices : " + Arrays.toString(updatedPPULArray));

        List<ProductPriceUnit> updatedPPUList = null;
        if (updatedPPULArray != null ) {
            updatedPPUList = Arrays.asList(updatedPPULArray);
        }else{

            logger.error("got null response from the /priceservice/prices POST.");
        }

        //也可以通过使用json序列化和反序列化来解决
        //可以参考getAllProductPrice调用

        return updatedPPUList;
    }

    public List<ProductPriceUnit> getAllProductPrice(){

        String priceServerUrl = PRICESERVER + "/priceservice/prices";

        /*Map<String, String> urlVariables = new HashMap<String, String>();
        urlVariables.put("productid", "1");
        urlVariables.put("productname", "win1");*/

        String jsonPPUList = restTemplate.getForObject(priceServerUrl, String.class);

        logger.info("Got response from priceservice: " + jsonPPUList);

        if(jsonPPUList == null){
            logger.error("getAllProductPrice() called and Got null response from /priceservice/prices ");
        }

        ObjectMapper mapper = new ObjectMapper();
        List<ProductPriceUnit> ppuList = null;
        try {
            ppuList = mapper.readValue(jsonPPUList, new TypeReference<List<ProductPriceUnit>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ppuList;
    }



}
