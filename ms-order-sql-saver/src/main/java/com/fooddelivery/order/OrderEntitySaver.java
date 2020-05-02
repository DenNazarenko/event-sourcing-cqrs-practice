package com.fooddelivery.order;

import com.fooddelivery.order.event.BaseEvent;
import com.fooddelivery.order.event.ConfirmOrderPaymentEvent;
import com.fooddelivery.order.event.CreateOrderEvent;
import com.fooddelivery.order.model.OrderStatus;
import com.fooddelivery.order.persistence.OrderQueryEntity;
import com.fooddelivery.order.persistence.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEntitySaver {

    private final OrderRepository orderRepository;

    @KafkaListener(topics = "order-events", groupId = "group2")
    public void on(BaseEvent event) { //todo switch to java 14 and try pattern matching
        log.info("Event received: " + event.getClass().getName());
        if (event instanceof CreateOrderEvent) {
            on((CreateOrderEvent) event);
        } else if (event instanceof ConfirmOrderPaymentEvent) {
            on((ConfirmOrderPaymentEvent) event);
        }
    }

    private void on(CreateOrderEvent event) {
        OrderQueryEntity entity = orderRepository.findById(event.id)
                .orElse(new OrderQueryEntity());
        entity.setId(event.id);
        entity.setStatus(OrderStatus.CREATED);
        entity.setAmountByProductId(event.amountByProductId);
        orderRepository.save(entity);
    }

    public void on(ConfirmOrderPaymentEvent event) {
        OrderQueryEntity entity = orderRepository.getOne(event.id);
        entity.setStatus(OrderStatus.PAID);
        orderRepository.save(entity);
    }
}
