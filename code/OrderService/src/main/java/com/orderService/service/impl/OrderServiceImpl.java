package com.orderService.service.impl;

import com.orderService.dao.impl.OrderDaoJdbcImpl;
import com.orderService.dto.OrderDTO;
import com.orderService.dto.events.OrderEventDTO;
import com.orderService.events.publisher.impl.OrderPublisherImpl;
import com.orderService.mapper.dtoToModelMapper.OrderDtoToOrderModelMapper;
import com.orderService.mapper.modelToPublisherMapper.OrderModelToOrderEventDto;
import com.orderService.model.OrderModel;
import com.orderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService<OrderDTO> {

    @Autowired
    private OrderDaoJdbcImpl orderDao;

    @Autowired
    private OrderDtoToOrderModelMapper orderDtoToOrderModelMapper;

    @Autowired
    private OrderPublisherImpl orderPublisher;

    @Autowired
    private OrderModelToOrderEventDto orderModelToOrderPublisherDto;

    @Override
    public int placeOrder(OrderDTO order) {
        OrderModel orderModel = orderDtoToOrderModelMapper.mapTo(order);
        int orderId = orderDao.placeOrder(orderModel);
        orderModel.setOrderId(orderId);
        OrderEventDTO orderPublisherDto = orderModelToOrderPublisherDto.mapTo(orderModel);
        orderPublisher.publishOrder(orderPublisherDto);
        return orderId;
    }
}
