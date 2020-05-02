package com.fooddelivery.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventSaverHdfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventSaverHdfsApplication.class, args);
    }

}
