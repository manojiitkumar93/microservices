package com.orderService.mapper.dtoToModelMapper;

import com.orderService.constants.StatusConstants;
import com.orderService.dto.OrderDTO;
import com.orderService.mapper.ObjectMapper;
import com.orderService.model.OrderModel;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoToOrderModelMapper implements ObjectMapper<OrderDTO, OrderModel> {

    @Autowired
    private OrderDtoToOrderDetailsMapper orderDtoToOrderDetailsMapper;

    @Override
    public OrderDTO mapFrom(@NonNull OrderModel o) {
        return null;
    }

    @Override
    public OrderModel mapTo(@NonNull  OrderDTO orderDTO) {
        OrderModel orderModel = new OrderModel();
        orderModel.setAddressId(orderDTO.getAddressId());
        orderModel.setUserId(orderDTO.getUserId());
        orderModel.setStatus(StatusConstants.ORDER_PENDING);
        orderModel.setOrderDetails(orderDtoToOrderDetailsMapper.mapTo(orderDTO));
        return orderModel;
    }


}
