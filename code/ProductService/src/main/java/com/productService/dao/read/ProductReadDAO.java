package com.productService.dao.read;

import com.productService.dto.ProductBasicDTO;
import com.productService.dto.ProductQuantityDTO;

import java.util.List;

public interface ProductReadDAO {

    List<ProductBasicDTO> getProducts(List<Integer> ids);

    List<ProductQuantityDTO> getProductQuantity(List<Integer> ids);


}
