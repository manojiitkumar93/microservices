package com.productService.controller.command;

import com.productService.dto.ProductBasicDTO;
import com.productService.service.ProductCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@ConditionalOnProperty(name = "product.write.enabled", havingValue = "true")
public class ProductCommandController {

    @Autowired
    private ProductCommandService productCommandService;

    @PostMapping("/{id}")
    public void updateProduct(ProductBasicDTO productDTO){

    }




}
