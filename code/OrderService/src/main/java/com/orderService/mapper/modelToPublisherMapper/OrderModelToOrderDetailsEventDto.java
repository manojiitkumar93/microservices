package com.orderService.mapper.modelToPublisherMapper;

import com.orderService.dto.events.OrderDetailsEventDTO;
import com.orderService.mapper.ObjectMapper;
import com.orderService.model.OrderModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderModelToOrderDetailsEventDto implements ObjectMapper<OrderModel, List<OrderDetailsEventDTO>> {
    @Override
    public OrderModel mapFrom(List<OrderDetailsEventDTO> o) {
        return null;
    }

    @Override
    public List<OrderDetailsEventDTO> mapTo(OrderModel orderModel) {
        List<OrderDetailsEventDTO> orderDetialsEvents = new ArrayList<>();
        orderModel.getOrderDetails().forEach(orderDetails -> {
                OrderDetailsEventDTO orderDetailsEventDTO = new OrderDetailsEventDTO();
                orderDetailsEventDTO.setProductId(orderDetails.getProductId());
                orderDetailsEventDTO.setQuantityOrdered(orderDetails.getQuantity());
                orderDetialsEvents.add(orderDetailsEventDTO);
        });
        return orderDetialsEvents;
    }
}
