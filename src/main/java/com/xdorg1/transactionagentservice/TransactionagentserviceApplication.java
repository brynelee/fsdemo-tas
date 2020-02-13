package com.xdorg1.transactionagentservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xdorg1.transactionagentservice.model")
public class TransactionagentserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionagentserviceApplication.class, args);
    }

}
