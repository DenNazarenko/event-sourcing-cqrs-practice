package com.fooddelivery.order.aggregate;

import com.fooddelivery.order.command.CreateProductCommand;
import com.fooddelivery.order.event.CreateProductEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        AggregateLifecycle.apply(new CreateProductEvent(createProductCommand.id, createProductCommand.name));
    }

    @EventSourcingHandler
    public void on(CreateProductEvent createProductEvent) {
        this.id = createProductEvent.id;
        this.name = createProductEvent.name;
    }
}
