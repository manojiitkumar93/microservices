package com.productService.queries.read;

public final class ProductReadQueries {

    public static final String GET_PRODUCTS_BY_IDS = "select id, name, price from products where id in $IDS;";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PRICE = "price";

    public static final String GET_QUANTITY_BY_IDS = "select id,quantity from products where id in";
    public static final String QUANTITY = "quantity";
}
