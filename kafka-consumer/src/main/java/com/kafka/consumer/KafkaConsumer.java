package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "topic-1", groupId = "group-1")
    public void consumeMessagesFromKafkaTopic(String msg){

        System.out.println(msg);

    }
    
}
