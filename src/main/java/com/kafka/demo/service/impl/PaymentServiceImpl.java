package com.kafka.demo.service.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.demo.constant.Constants;
import com.kafka.demo.dto.PaymentDTO;
import com.kafka.demo.service.KafkaService;
import com.kafka.demo.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
    private static final Logger logger = LogManager.getLogger(KafkaServiceImpl.class);
    @Autowired
    private KafkaService kafkaService;
    @Override
    public void changePaymentStatus(PaymentDTO paymentDTO) {
        logger.info("changePaymentStatus message: {}", paymentDTO);
        kafkaService.sendMessage(Constants.PAYMENT_TOPIC, paymentDTO);
    }
    
}