package com.productService.events.producer;

import com.productService.dto.events.RollBackEventDTO;

public interface OrderProducer {

    void createOrderFailureEvent(RollBackEventDTO rollBackEventDTO);
}
