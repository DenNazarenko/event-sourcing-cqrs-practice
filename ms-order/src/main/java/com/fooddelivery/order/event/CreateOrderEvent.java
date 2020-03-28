package com.fooddelivery.order.event;

import java.util.Map;

public class CreateOrderEvent extends OrderEvent {

    public final Map<String, Integer> amountByProductId;

    public CreateOrderEvent(String id, Map<String, Integer> amountByProductId) {
        super(id);
        this.amountByProductId = amountByProductId;
    }
}
