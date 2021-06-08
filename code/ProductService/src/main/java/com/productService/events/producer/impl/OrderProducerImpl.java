package com.productService.events.producer.impl;

import com.productService.dto.events.RollBackEventDTO;
import com.productService.events.producer.OrderProducer;
import org.springframework.stereotype.Component;

@Component
public class OrderProducerImpl implements OrderProducer {

    @Override
    public void createOrderFailureEvent(RollBackEventDTO rollBackEventDTO) {

    }
}
