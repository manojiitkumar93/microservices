package com.productService.service;

import com.productService.dto.ProductBasicDTO;
import com.productService.dto.ProductQuantityDTO;

import java.util.List;

public interface ProductReadService {

     List<ProductBasicDTO> getProductDetails(List<Integer> productIds);

     List<ProductQuantityDTO> getProductQuantity(List<Integer> productsIds);
}
