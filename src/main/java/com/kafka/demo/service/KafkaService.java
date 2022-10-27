package com.kafka.demo.service;

public interface KafkaService {
    public void sendMessage(String topicName, Object dto);
}
