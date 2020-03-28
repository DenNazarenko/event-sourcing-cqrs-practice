package com.fooddelivery.order.persistence;

import com.fooddelivery.order.aggregate.OrderAggregate;
import com.fooddelivery.order.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEntityManager {

    private final OrderRepository orderRepository;

    @Autowired
    @Qualifier("orderAggregateEventSourcingRepository")
    private EventSourcingRepository<OrderAggregate> orderAggregateEventSourcingRepository;

    @EventSourcingHandler
    public void on(OrderEvent event) {
        OrderAggregate orderAggregate = orderAggregateEventSourcingRepository.load(event.id)
                .getWrappedAggregate().getAggregateRoot();
        OrderQueryEntity orderQueryEntity = buildOrderQueryEntity(orderAggregate);
        orderRepository.save(orderQueryEntity);
    }

    private OrderQueryEntity buildOrderQueryEntity(OrderAggregate orderAggregate) {
        OrderQueryEntity orderQueryEntity = orderRepository.findById(orderAggregate.getId())
                .orElse(new OrderQueryEntity());
        orderQueryEntity.setId(orderAggregate.getId());
        orderQueryEntity.setStatus(orderAggregate.getStatus());
        orderQueryEntity.setAmountByProductId(orderAggregate.getAmountByProductId());
        return orderQueryEntity;
    }
}
