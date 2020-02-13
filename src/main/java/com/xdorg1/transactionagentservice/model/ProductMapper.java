package com.xdorg1.transactionagentservice.model;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductMapper {

    @Select("select * from product order by product_id desc")
    List<Product> getProductList();
}
