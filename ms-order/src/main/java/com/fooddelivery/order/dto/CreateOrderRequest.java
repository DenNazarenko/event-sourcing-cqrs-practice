package com.fooddelivery.order.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CreateOrderRequest {

    public Map<String, Integer> amountByProductId;
}
