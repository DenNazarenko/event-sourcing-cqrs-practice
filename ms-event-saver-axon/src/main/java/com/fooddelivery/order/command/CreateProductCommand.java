package com.fooddelivery.order.command;

public class CreateProductCommand extends BaseCommand {

    public String name;

    public CreateProductCommand(String id, String name) {
        super(id);
        this.name = name;
    }
}
