package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/")
    public String getHello(){
        return "Hellow";
    }

    @GetMapping("/produce")
    public void produceMessagesToKafkaTopic() throws InterruptedException{
        int n = 10;
        while(n > 0){
            kafkaTemplate.send("topic-1", "Message no " + n + " : " + Math.random()*n);
            Thread.sleep(2000);
            n--;
        }
    }
    
}
