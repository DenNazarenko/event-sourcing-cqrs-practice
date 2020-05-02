package com.fooddelivery.order.service;

import com.fooddelivery.order.dto.CreateOrderRequest;
import com.fooddelivery.order.event.BaseEvent;
import com.fooddelivery.order.event.ConfirmOrderPaymentEvent;
import com.fooddelivery.order.event.CreateOrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderCommandService {

    private final KafkaTemplate<String, BaseEvent> kafkaTemplate;

    public String createOrder(CreateOrderRequest createOrderRequest) {
        String id = UUID.randomUUID().toString();
        kafkaTemplate.send("order-events", new CreateOrderEvent(id, createOrderRequest.amountByProductId));
        return id;
    }

    public void confirmPayment(String orderId) {
        kafkaTemplate.send("order-events", new ConfirmOrderPaymentEvent(orderId));
    }
}
