package com.kafka.message.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Consumer {
    @KafkaListener(topics = "${cloudkarafka.topic:}")
    void listen(String message, @Header(value = KafkaHeaders.PARTITION_ID, required = false) String partitionId, @Headers Object headers) {
        System.out.println("Received message:: "+message);
        System.out.println("Partition ID::"+partitionId);
        System.out.println(headers);
    }
}
