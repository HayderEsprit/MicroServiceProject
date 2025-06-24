package com.patien.mspatien.Kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaTextMessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendTextMessage(String message) {
        kafkaTemplate.send("patient-text-topic", message);
        System.out.println("Message texte envoyé: " + message);
    }
}