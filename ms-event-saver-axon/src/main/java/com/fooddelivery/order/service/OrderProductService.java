package com.fooddelivery.order.service;

import com.fooddelivery.order.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProductService {

    private final CommandGateway commandGateway;

    @Scheduled(fixedDelay = Long.MAX_VALUE, initialDelay = 2000L)
    public void init() {
        commandGateway.send(new CreateProductCommand("1", "burger"));
        commandGateway.send(new CreateProductCommand("2", "pizza"));
        commandGateway.send(new CreateProductCommand("3", "sushi"));
    }
}
