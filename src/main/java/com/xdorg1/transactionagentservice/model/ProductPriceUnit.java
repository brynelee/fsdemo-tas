package com.xdorg1.transactionagentservice.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductPriceUnit {
    public int ProductId;
    public String ProductName;
    public BigDecimal Price;
    public Date UpdateTime;

    @Override
    public String toString() {
        return "ProductID=" + ProductId + ", ProductName=" + ProductName + ", Price=" + Price + ", UpdateTime=" + UpdateTime;
    }
}
