package com.productService.dto.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDetailsEventDTO {
    private int productId;
    private int price;
    private int quantityOrdered;
}
