package com.productService.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductQuantityDTO {
    private int id;
    private int price;
    private int quantity;
}
