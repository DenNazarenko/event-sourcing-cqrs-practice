package com.fooddelivery.order;

import com.fooddelivery.order.persistence.OrderQueryEntity;
import com.fooddelivery.order.persistence.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderQueryService {

    private final OrderRepository orderRepository;

    public Order getOrder(String orderId) {
        OrderQueryEntity orderQueryEntity = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException(("Order with such id hasn't been found")));
        Order order = new Order();
        BeanUtils.copyProperties(orderQueryEntity, order);
        return order;
    }
}
