package com.orderService.controller;

import com.orderService.dto.OrderDTO;
import com.orderService.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;


    @PostMapping("/")
    public int placeOrder(@RequestBody OrderDTO orderDto){
        return orderService.placeOrder(orderDto);
    }
}
