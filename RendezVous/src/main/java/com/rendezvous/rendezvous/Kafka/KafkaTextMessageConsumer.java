package com.rendezvous.rendezvous.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTextMessageConsumer {

//    @KafkaListener(topics = "patient-text-topic", groupId = "group-1")
//    public void consumeTextMessage(String message) {
//        System.out.println("Message texte reçu: " + message);
//        // Traitez le message texte ici
//    }
}
