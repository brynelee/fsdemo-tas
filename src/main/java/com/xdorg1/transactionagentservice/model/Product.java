package com.xdorg1.transactionagentservice.model;

/*

CREATE TABLE `product`  (
  `product_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '产品名称',
  `total_amount` int(10) UNSIGNED NOT NULL COMMENT '总份额',
  `amount_sold` int(10) UNSIGNED NOT NULL COMMENT '已销售份额',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `institution_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '机构编码',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '产品一级分类',
  `unit_price` decimal(10, 2) UNSIGNED NOT NULL COMMENT '份额单价',
  `isDynamicPrice` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否是动态价格',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

 */

import java.math.BigDecimal;

public class Product {

    private int product_id;
    private String product_name;
    private int total_amount;
    private int amount_sold;
    private String description;
    private String institution_code;
    private String category;
    private BigDecimal unit_price; //Java中需要BigDecimal来实现精确计算
    private boolean isDynamicPrice; //MySQL中使用tinyint(1)来实现boolean类型

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public int getAmount_sold() {
        return amount_sold;
    }

    public void setAmount_sold(int amount_sold) {
        this.amount_sold = amount_sold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstitution_code() {
        return institution_code;
    }

    public void setInstitution_code(String institution_code) {
        this.institution_code = institution_code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public boolean isDynamicPrice() {
        return isDynamicPrice;
    }

    public void setDynamicPrice(boolean dynamicPrice) {
        isDynamicPrice = dynamicPrice;
    }

    @Override
    public String toString() {
        return "Product [id=" + product_id + ", product name=" + product_name + ", price=" + unit_price +", category=" + category + ", institution=" + institution_code + "]";
    }
}
