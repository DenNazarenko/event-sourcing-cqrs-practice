package com.fooddelivery.order.dto;

import com.fooddelivery.order.aggregate.OrderStatus;
import lombok.Data;

import java.util.Map;

@Data
public class Order {

    private String id;
    private OrderStatus status;
    private Map<String, Integer> amountByProductId;

}
