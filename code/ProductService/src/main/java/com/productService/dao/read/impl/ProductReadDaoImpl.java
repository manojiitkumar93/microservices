package com.productService.dao.read.impl;

import com.productService.constants.ReplaceConstants;
import com.productService.dao.read.ProductReadDAO;
import com.productService.dto.ProductBasicDTO;
import com.productService.dto.ProductQuantityDTO;
import com.productService.helper.query.QueryConstructor;
import com.productService.mapper.ProductQuntityRowMapper;
import com.productService.mapper.ProductsBasicRowMapper;
import com.productService.queries.read.ProductReadQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductReadDaoImpl implements ProductReadDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductBasicDTO> getProducts(List<Integer> ids) {
        String query = ProductReadQueries.GET_PRODUCTS_BY_IDS.replace(ReplaceConstants.IN_REPLACE, QueryConstructor.constructInQuery(ids));
        return jdbcTemplate.query(query, new ProductsBasicRowMapper());
    }

    @Override
    public List<ProductQuantityDTO> getProductQuantity(List<Integer> ids) {
        String query = ProductReadQueries.GET_QUANTITY_BY_IDS.replace(ReplaceConstants.IN_REPLACE, QueryConstructor.constructInQuery(ids));
        return jdbcTemplate.query(query,new ProductQuntityRowMapper());
    }
}
