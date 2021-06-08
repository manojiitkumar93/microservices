package com.orderService.service;

public interface OrderService<O> {

    int placeOrder(O order);
}
