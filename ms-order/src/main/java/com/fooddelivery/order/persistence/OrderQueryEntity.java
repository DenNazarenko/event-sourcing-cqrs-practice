package com.fooddelivery.order.persistence;

import com.fooddelivery.order.aggregate.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class OrderQueryEntity {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
