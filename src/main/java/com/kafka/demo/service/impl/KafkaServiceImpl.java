package com.kafka.demo.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.kafka.demo.service.KafkaService;

@Service
public class KafkaServiceImpl implements KafkaService {
    @Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

    private static final Logger logger = LogManager.getLogger(KafkaServiceImpl.class);

    @Override
    public void sendMessage(String topicName, Object message) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topicName, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("Unable to send message: {}, due to: {}", message, ex.getMessage());
            }
            @Override
            public void onSuccess(SendResult<String, Object> result) {
                logger.info("Sent message: {} with offset: {}", message, result.getRecordMetadata().offset());
            }
        });
    }
}
