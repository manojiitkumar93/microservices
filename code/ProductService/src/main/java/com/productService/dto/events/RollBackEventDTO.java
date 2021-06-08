package com.productService.dto.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RollBackEventDTO {
    private String message;
    private int orderId;
}
