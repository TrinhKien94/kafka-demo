package com.kafka.demo.service;

import com.kafka.demo.dto.PaymentDTO;

public interface PaymentService {
    public void changePaymentStatus(PaymentDTO paymentDTO);
}
