package com.productService.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDetailedDTO {
    private int id;
    private String name;
    private int price;
    private String description;
}
