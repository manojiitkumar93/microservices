package com.orderService.dto.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDetailsEventDTO {
    private int productId;
    private int quantityOrdered;
}
