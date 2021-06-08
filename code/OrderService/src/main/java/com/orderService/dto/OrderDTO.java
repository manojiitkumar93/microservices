package com.orderService.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderDTO {

    private List<OrderDetailsDTO> orderDetails;
    private int userId;
    private int addressId;

}
