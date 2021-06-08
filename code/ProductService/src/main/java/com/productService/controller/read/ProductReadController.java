package com.productService.controller.read;

import com.productService.dto.ProductBasicDTO;
import com.productService.dto.ProductQuantityDTO;
import com.productService.service.impl.ProductReadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductReadController {

    @Autowired
    private ProductReadServiceImpl productReadServiceImpl;

    @GetMapping("/{ids}")
    public List<ProductBasicDTO> getProductDetails(@PathVariable("ids") String ids){
        String[] idArray= ids.split(",");
        List<Integer> finalIds = Arrays.asList(idArray).stream().map(id-> Integer.parseInt(id)).collect(Collectors.toList());
        return productReadServiceImpl.getProductDetails(finalIds);
    }

    @GetMapping("/quantity/{ids}")
    public List<ProductQuantityDTO> getProductQuantity(@PathVariable("ids") String ids){
        String[] idArray= ids.split(",");
        List<Integer> finalIds = Arrays.asList(idArray).stream().map(id-> Integer.parseInt(id)).collect(Collectors.toList());
        return productReadServiceImpl.getProductQuantity(finalIds);
    }



}
