package com.productService.events.consumer.impl;

import com.productService.dto.ProductQuantityDTO;
import com.productService.dto.events.OrderDetailsEventDTO;
import com.productService.dto.events.OrderEventDTO;
import com.productService.dto.events.PaymentEventDTO;
import com.productService.dto.events.RollBackEventDTO;
import com.productService.events.consumer.OrderConsumer;
import com.productService.events.producer.OrderProducer;
import com.productService.events.producer.impl.OrderProducerImpl;
import com.productService.events.producer.impl.PaymentProducerImpl;
import com.productService.service.impl.ProductReadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OrderConsumerImpl implements OrderConsumer {

    @Autowired
    private ProductReadServiceImpl productReadService;

    @Autowired
    private OrderProducerImpl orderProducer;

    @Autowired
    private PaymentProducerImpl paymentProducer;

    @Value("orderService.consumer.topic")
    private String orderTopic;

    @Value("spring.kafka.consumer.group-id")
    private String consumerGroupId;

    @Override
    @KafkaListener(groupId = "${consumerGroupId}", topics = {"${orderTopic}"})
    public void consumeOrder(OrderEventDTO orderEventDTO) {


    }

    private void checkStockAvailableAndPublishNextEvents(List<ProductQuantityDTO> productQuantityDTOs, List<OrderDetailsEventDTO> orderDetailsEventDtos, int orderId) {
        Map<Integer, Integer> orderedProductToQuantityMap = orderDetailsEventDtos.stream().collect(Collectors.toMap(OrderDetailsEventDTO::getProductId, OrderDetailsEventDTO::getQuantityOrdered));
        boolean canOrderBeProcessedONextStep = true;
        int toalAmount = 0;
        for(ProductQuantityDTO productQuantityDto: productQuantityDTOs){
            int quantityAvailable = productQuantityDto.getQuantity();
            int quantityOrdered = orderedProductToQuantityMap.get(productQuantityDto.getId());

            if(quantityAvailable < quantityOrdered){
                canOrderBeProcessedONextStep = false;
                break;
            }
            toalAmount = productQuantityDto.getPrice() + toalAmount;
        }

        if(canOrderBeProcessedONextStep){
            PaymentEventDTO paymentEventDTO = createPaymentEventDTO(toalAmount);
            paymentProducer.producePaymentEvent(paymentEventDTO);
        }
        else{
            RollBackEventDTO rollBackEventDTO = createRollBackEventDTO("Out Of Stock", orderId);
            orderProducer.createOrderFailureEvent(rollBackEventDTO);
        }
    }

    private RollBackEventDTO createRollBackEventDTO(String message, int orderId) {
        RollBackEventDTO rollBackEventDTO = new RollBackEventDTO();
        rollBackEventDTO.setOrderId(orderId);
        rollBackEventDTO.setMessage(message);
        return rollBackEventDTO;
    }

    private PaymentEventDTO createPaymentEventDTO(int price) {
        PaymentEventDTO paymentEventDTO = new PaymentEventDTO();
        paymentEventDTO.setPrice(price);
        return paymentEventDTO;
    }


}
