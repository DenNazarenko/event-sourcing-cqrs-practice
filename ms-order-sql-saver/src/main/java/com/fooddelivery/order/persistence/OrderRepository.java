package com.fooddelivery.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderQueryEntity, String> {
}
