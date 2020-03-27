package com.fooddelivery.order.service;

import com.fooddelivery.order.dto.Order;
import com.fooddelivery.order.persistence.OrderQueryEntity;
import com.fooddelivery.order.persistence.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderQueryService {

    private final EventStore eventStore;
    private final OrderRepository orderRepository;

    public List<Object> listEventsForOrder(String orderId) {
        return eventStore.readEvents(orderId).asStream().map(Message::getPayload).collect(Collectors.toList());
    }

    public Order getOrder(String orderId) {
        OrderQueryEntity orderQueryEntity = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException(("Order with such id hasn't been found")));
        Order order = new Order();
        BeanUtils.copyProperties(orderQueryEntity, order);
        return order;
    }
}
