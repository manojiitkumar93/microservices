package com.productService.service.impl;

import com.productService.dao.read.ProductReadDAO;
import com.productService.dto.ProductBasicDTO;
import com.productService.dto.ProductQuantityDTO;
import com.productService.service.ProductReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReadServiceImpl implements ProductReadService {
    @Autowired
    private ProductReadDAO productReadDAO;

    @Override
    public List<ProductBasicDTO> getProductDetails(List<Integer> productIds) {
        return productReadDAO.getProducts(productIds);
    }

    @Override
    public List<ProductQuantityDTO> getProductQuantity(List<Integer> productsIds) {
        return productReadDAO.getProductQuantity(productsIds);
    }
}
