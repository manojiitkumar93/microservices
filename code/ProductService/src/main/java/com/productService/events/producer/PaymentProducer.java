package com.productService.events.producer;

import com.productService.dto.events.PaymentEventDTO;

public interface PaymentProducer {

    void producePaymentEvent(PaymentEventDTO paymentEventDTO);


}
