package com.dinegrid.order_service.serviceImpl;

import com.dinegrid.order_service.dto.OrderPlacedEvent;
import com.dinegrid.order_service.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventProducer {

    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void publishOrderPlacedEvent(Order order) {
        OrderPlacedEvent event = new OrderPlacedEvent(order.getMenuItemId(), order.getQuantity());
        kafkaTemplate.send("order-events", event);
        log.info("Kafka event published: {}", event);
    }
}
