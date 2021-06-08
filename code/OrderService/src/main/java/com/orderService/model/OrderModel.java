package com.orderService.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderModel {

    private String status;
    private int userId;
    private int addressId;
    private int orderId;
    private List<OrderDetailsModel> orderDetails;

}
