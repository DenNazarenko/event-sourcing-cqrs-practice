package com.fooddelivery.order.service;

import com.fooddelivery.order.command.ConfirmOrderPaymentCommand;
import com.fooddelivery.order.command.CreateOrderCommand;
import com.fooddelivery.order.event.CreateOrderEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class OrderCommandService {

    private final CommandGateway commandGateway;

    public CompletableFuture<String> confirmPayment(String orderId) {
        return commandGateway.send(new ConfirmOrderPaymentCommand(orderId));
    }
}
