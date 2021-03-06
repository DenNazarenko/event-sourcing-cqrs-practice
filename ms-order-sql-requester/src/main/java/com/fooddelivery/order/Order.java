package com.fooddelivery.order;

import com.fooddelivery.order.model.OrderStatus;
import lombok.Data;

import java.util.Map;

@Data
public class Order {

    private String id;
    private OrderStatus status;
    private Map<String, Integer> amountByProductId;

}
