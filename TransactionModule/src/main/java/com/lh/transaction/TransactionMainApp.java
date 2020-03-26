package com.lh.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuhe
 * @date 2020/03/25
 */
@SpringBootApplication
@ComponentScan("com.lh.transaction")
public class TransactionMainApp {

    public static void main(String[] args) {
        SpringApplication.run(TransactionMainApp.class, args);
    }
}
