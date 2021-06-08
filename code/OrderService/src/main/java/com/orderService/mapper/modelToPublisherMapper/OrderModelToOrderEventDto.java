package com.orderService.mapper.modelToPublisherMapper;

import com.orderService.dto.events.OrderDetailsEventDTO;
import com.orderService.dto.events.OrderEventDTO;
import com.orderService.mapper.ObjectMapper;
import com.orderService.model.OrderModel;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderModelToOrderEventDto implements ObjectMapper<OrderModel, OrderEventDTO> {

    @Autowired
    private OrderModelToOrderDetailsEventDto orderModelToOrderDetailsEventDto;

    @Override
    public OrderModel mapFrom(OrderEventDTO o) {
        return null;
    }

    @Override
    public OrderEventDTO mapTo(@NonNull  OrderModel orderModel) {
        OrderEventDTO orderEventDTO = new OrderEventDTO();
        orderEventDTO.setOrderId(orderModel.getOrderId());
        List<OrderDetailsEventDTO> orderDetailsEventDtos = orderModelToOrderDetailsEventDto.mapTo(orderModel);
        orderEventDTO.setOrderDetailsEventDTOs(orderDetailsEventDtos);
        return orderEventDTO;
    }
}
