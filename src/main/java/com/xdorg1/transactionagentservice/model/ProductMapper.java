package com.xdorg1.transactionagentservice.model;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductMapper {

    @Select("select * from product order by product_id desc")
    List<Product> getProductList();

    @Select("select * from product where product_id=#{productid} and product_name=#{productname}")
    Product getProduct(@Param("productid") int productid, @Param("productname") String productname);

}
