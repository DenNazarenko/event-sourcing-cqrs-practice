package com.fooddelivery.order.event;

public class OrderEvent extends BaseEvent {

    public OrderEvent() {
    }

    public OrderEvent(String id) {
        super(id);
    }
}
