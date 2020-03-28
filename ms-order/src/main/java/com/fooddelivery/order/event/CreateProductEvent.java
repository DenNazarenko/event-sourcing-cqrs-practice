package com.fooddelivery.order.event;

public class CreateProductEvent extends ProductEvent {

    public String name;

    public CreateProductEvent(String id, String name) {
        super(id);
        this.name = name;
    }
}
