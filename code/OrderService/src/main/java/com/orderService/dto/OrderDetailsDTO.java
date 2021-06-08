package com.orderService.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDetailsDTO {
    private int productId;
    private int price;
    private int quantity;
}
