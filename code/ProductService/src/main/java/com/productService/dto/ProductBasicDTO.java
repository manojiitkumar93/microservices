package com.productService.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductBasicDTO {
    private int id;
    private String name;
    private int price;
}
