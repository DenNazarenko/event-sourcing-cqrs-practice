package com.fooddelivery.order.command;

import java.util.Map;

public class CreateOrderCommand extends BaseCommand {

    public Map<String, Integer> amountByProductId;

    public CreateOrderCommand(String id, Map<String, Integer> amountByProductId) {
        super(id);
        this.amountByProductId = amountByProductId;
    }
}
