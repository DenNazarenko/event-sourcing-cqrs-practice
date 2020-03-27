package com.fooddelivery.order.config;

import com.fooddelivery.order.aggregate.OrderAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<OrderAggregate> orderAggregateEventSourcingRepository(EventStore eventStore) {
        return EventSourcingRepository.builder(OrderAggregate.class)
                .eventStore(eventStore)
                .build();
    }
}
