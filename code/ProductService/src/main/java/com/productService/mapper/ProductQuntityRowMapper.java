package com.productService.mapper;

import com.productService.dto.ProductQuantityDTO;
import com.productService.queries.read.ProductReadQueries;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductQuntityRowMapper implements RowMapper<ProductQuantityDTO> {
    @Override
    public ProductQuantityDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductQuantityDTO productQuantityDTO = new ProductQuantityDTO();
        productQuantityDTO.setQuantity(resultSet.getInt(ProductReadQueries.QUANTITY));
        productQuantityDTO.setId(resultSet.getInt(ProductReadQueries.ID));
        return productQuantityDTO;
    }
}
