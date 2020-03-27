package com.fooddelivery.order.persistence;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderQueryEntity, String> {
}
