package com.orderService.events.publisher;

public interface OrderPublisher<O> {

    void publishOrder(O order);
}
