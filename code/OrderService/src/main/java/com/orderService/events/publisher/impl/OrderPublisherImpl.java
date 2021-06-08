package com.orderService.events.publisher.impl;

import com.orderService.dto.events.OrderEventDTO;
import com.orderService.events.publisher.OrderPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderPublisherImpl implements OrderPublisher<OrderEventDTO> {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("spring.kafka.orderPublish.topic")
    private String topic;

    @Override
    public void publishOrder(OrderEventDTO order) {
        kafkaTemplate.send(topic, order);
    }
}
