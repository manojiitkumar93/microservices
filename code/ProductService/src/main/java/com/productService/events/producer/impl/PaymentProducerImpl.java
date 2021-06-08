package com.productService.events.producer.impl;

import com.productService.dto.events.PaymentEventDTO;
import com.productService.events.producer.PaymentProducer;
import org.springframework.stereotype.Component;

@Component
public class PaymentProducerImpl implements PaymentProducer {
    @Override
    public void producePaymentEvent(PaymentEventDTO paymentEventDTO) {

    }
}
