package com.fooddelivery.order.event;

public class ProductEvent extends BaseEvent {

    public ProductEvent() {
    }

    public ProductEvent(String id) {
        super(id);
    }
}
