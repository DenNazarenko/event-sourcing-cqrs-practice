package com.fooddelivery.order.controller;

import com.fooddelivery.order.dto.CreateOrderRequest;
import com.fooddelivery.order.service.OrderCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderCommandController {

    private final OrderCommandService orderCommandService;

    @PostMapping
    public CompletableFuture<String> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return orderCommandService.createOrder(createOrderRequest);
    }

    @PostMapping("{orderId}/confirm-payment")
    public CompletableFuture<String> confirmPayment(@PathVariable("orderId") String orderId) {
        return orderCommandService.confirmPayment(orderId);
    }
}
