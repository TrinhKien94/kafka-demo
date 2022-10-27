package com.kafka.demo.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.kafka.demo.constant.Constants;

import org.springframework.kafka.support.KafkaHeaders;
@Component
@KafkaListener(topics = Constants.PAYMENT_TOPIC)
public class PaymentHandler {
    private static final Logger logger = LogManager.getLogger(PaymentHandler.class);
    @KafkaHandler
    public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
      logger.info("Received Message: {} from partition: {}", message ,  partition);
    }
}
