package com.orderService.queries;

public final class OrderDetailsQueries {

    public static final  String CREATE_ORDER_DETAILS = "insert into order_details(order_id, product_id, quantity) values(?,?,?);";
}
