package com.fooddelivery.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrderSqlSaverApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSqlSaverApplication.class, args);
    }

}
