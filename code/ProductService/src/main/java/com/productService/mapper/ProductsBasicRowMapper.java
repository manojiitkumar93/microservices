package com.productService.mapper;

import com.productService.dto.ProductBasicDTO;
import com.productService.queries.read.ProductReadQueries;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductsBasicRowMapper implements RowMapper<ProductBasicDTO> {

    @Override
    public ProductBasicDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductBasicDTO productBasicDTO = new ProductBasicDTO();
        productBasicDTO.setId(resultSet.getInt(ProductReadQueries.ID));
        productBasicDTO.setPrice(resultSet.getInt(ProductReadQueries.PRICE));
        productBasicDTO.setName(resultSet.getString(ProductReadQueries.NAME));
        return productBasicDTO;
    }
}
