package com.fooddelivery.order.event;

public class ConfirmOrderPaymentEvent extends OrderEvent {

    public ConfirmOrderPaymentEvent(String id) {
        super(id);
    }
}
