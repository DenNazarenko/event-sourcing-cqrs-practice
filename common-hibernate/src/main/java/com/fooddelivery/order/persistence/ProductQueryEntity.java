package com.fooddelivery.order.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductQueryEntity {

    @Id
    private String id;

    private String name;
}
