package com.productService.events.consumer;

import com.productService.dto.events.OrderEventDTO;

public interface OrderConsumer {

    void consumeOrder(OrderEventDTO orderEventDTO);
}
