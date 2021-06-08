package com.orderService.dao.impl;

import com.orderService.dao.OrderDao;
import com.orderService.model.OrderModel;
import com.orderService.queries.OrderDetailsQueries;
import com.orderService.queries.OrderQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class OrderDaoJdbcImpl implements OrderDao<OrderModel> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public int placeOrder(OrderModel order) {
        Object[] object = new Object[]{order.getUserId(), order.getAddressId(), order.getStatus()};
        int orderId = jdbcTemplate.update(OrderQueries.CREATE_ORDER, object);
        createOrderDetails(orderId, order);
        return orderId;
    }

    private int[] createOrderDetails(int orderId, OrderModel order){
        return jdbcTemplate.batchUpdate(OrderDetailsQueries.CREATE_ORDER_DETAILS, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, orderId);
                preparedStatement.setInt(2,order.getOrderDetails().get(i).getProductId());
                preparedStatement.setInt(3,order.getOrderDetails().get(i).getQuantity());
            }

            @Override
            public int getBatchSize() {
                return order.getOrderDetails().size();
            }
        });
    }
}
