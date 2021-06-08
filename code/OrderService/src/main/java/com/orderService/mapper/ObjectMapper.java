package com.orderService.mapper;

public interface ObjectMapper <I,O> {

    I mapFrom(O o);

    O mapTo(I i);
}
