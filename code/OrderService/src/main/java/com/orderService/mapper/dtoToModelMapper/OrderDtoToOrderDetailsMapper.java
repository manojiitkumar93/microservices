package com.orderService.mapper.dtoToModelMapper;

import com.orderService.dto.OrderDTO;
import com.orderService.mapper.ObjectMapper;
import com.orderService.model.OrderDetailsModel;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDtoToOrderDetailsMapper implements ObjectMapper<OrderDTO, List<OrderDetailsModel>> {
    @Override
    public OrderDTO mapFrom(@NonNull  List<OrderDetailsModel> o) {
        return null;
    }

    @Override
    public List<OrderDetailsModel> mapTo(@NonNull  OrderDTO orderDTO) {
        List<OrderDetailsModel> orderDetails = new ArrayList<>();
        orderDTO.getOrderDetails().forEach(orderDetail -> {
            OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
            orderDetailsModel.setProductId(orderDetail.getProductId());
            orderDetailsModel.setQuantity(orderDetail.getQuantity());
            orderDetails.add(orderDetailsModel);
        });
        return orderDetails;
    }
}
