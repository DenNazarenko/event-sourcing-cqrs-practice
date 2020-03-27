package com.fooddelivery.order.service;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderQueryService {

    private final EventStore eventStore;

    public List<Object> listEventsForOrder(String orderId) {
        return eventStore.readEvents(orderId).asStream().map(Message::getPayload).collect(Collectors.toList());
    }
}
