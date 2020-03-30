package com.fooddelivery.order.producer;

import com.fooddelivery.order.event.BaseEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventProducer {

    private final KafkaTemplate<String, BaseEvent> kafkaTemplate;

    @EventSourcingHandler
    public void on(BaseEvent event) {
        kafkaTemplate.send("test", event);
    }
}
