package com.fooddelivery.order.dto;

import com.fooddelivery.order.aggregate.OrderStatus;
import lombok.Data;

@Data
public class Order {

    private String id;
    private OrderStatus status;
}
