package com.fooddelivery.order.event;

public class CreateOrderEvent extends BaseEvent {

    public CreateOrderEvent(String id) {
        super(id);
    }
}
