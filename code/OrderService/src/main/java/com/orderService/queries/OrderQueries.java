package com.orderService.queries;

public class OrderQueries {

    public static final String CREATE_ORDER = "insert into orders(user_id,address_id,status) values(?,?,?);";
}
