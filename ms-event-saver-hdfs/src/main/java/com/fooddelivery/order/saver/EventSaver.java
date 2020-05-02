package com.fooddelivery.order.saver;

import com.fooddelivery.order.event.BaseEvent;
import com.fooddelivery.order.event.ConfirmOrderPaymentEvent;
import com.fooddelivery.order.event.CreateOrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventSaver {

    @KafkaListener(topics = "order-events", groupId = "group1")
    public void on(BaseEvent baseEvent) {
        log.info("Event has been received");
        if (baseEvent instanceof CreateOrderEvent) {
            // todo save in hdfs
        } else if (baseEvent instanceof ConfirmOrderPaymentEvent) {
            // todo save in hdfs
        }
    }

}
