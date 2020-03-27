package com.fooddelivery.order.controller;

import com.fooddelivery.order.service.OrderCommandService;
import com.fooddelivery.order.service.OrderQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderQueryController {

    private final OrderQueryService orderQueryService;

    @GetMapping("{orderId}/events")
    public List<Object> listEventsForOrder(@PathVariable("orderId") String orderId) {
        return orderQueryService.listEventsForOrder(orderId);
    }

}
