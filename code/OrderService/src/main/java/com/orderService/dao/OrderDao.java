package com.orderService.dao;

public interface OrderDao<O> {

    int placeOrder(O orderModel);
}
