package com.fooddelivery.order.event;

public class ConfirmOrderPaymentEvent extends OrderEvent {

    public ConfirmOrderPaymentEvent() {
    }

    public ConfirmOrderPaymentEvent(String id) {
        super(id);
    }
}
