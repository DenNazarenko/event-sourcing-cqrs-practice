package com.fooddelivery.order.persistence;

import com.fooddelivery.order.aggregate.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import java.util.Map;

@Entity
@Getter
@Setter
public class OrderQueryEntity {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ElementCollection
    @CollectionTable(name = "order_product_amount", joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "product_id")
    @Column(name = "amount")
    private Map<String, Integer> amountByProductId;
}
