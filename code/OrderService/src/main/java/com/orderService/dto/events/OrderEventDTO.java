package com.orderService.dto.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderEventDTO {
    private int orderId;
    private List<OrderDetailsEventDTO> orderDetailsEventDTOs;
}
