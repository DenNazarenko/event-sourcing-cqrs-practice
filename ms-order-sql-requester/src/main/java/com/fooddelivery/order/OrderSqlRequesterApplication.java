package com.fooddelivery.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrderSqlRequesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSqlRequesterApplication.class, args);
    }

}
