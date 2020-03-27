package com.fooddelivery.order.aggregate;

import com.fooddelivery.order.command.ConfirmOrderPaymentCommand;
import com.fooddelivery.order.command.CreateOrderCommand;
import com.fooddelivery.order.event.ConfirmOrderPaymentEvent;
import com.fooddelivery.order.event.CreateOrderEvent;
import lombok.Getter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Getter
public class OrderAggregate {

    @AggregateIdentifier
    private String id; //todo try make them final

    private OrderStatus status;

    //todo add field

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand) {
        AggregateLifecycle.apply(new CreateOrderEvent(createOrderCommand.id));
    }

    @EventSourcingHandler
    public void on(CreateOrderEvent createOrderEvent) {
        this.id = createOrderEvent.id;
        this.status = OrderStatus.CREATED;
    }

    @CommandHandler
    public void on(ConfirmOrderPaymentCommand confirmOrderPaymentCommand) {
        AggregateLifecycle.apply(new ConfirmOrderPaymentEvent(confirmOrderPaymentCommand.id));
    }

    @EventSourcingHandler
    public void on(ConfirmOrderPaymentEvent confirmOrderPaymentEvent) {
        this.status = OrderStatus.PAID;
    }

}
