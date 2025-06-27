package com.patien.mspatien.Kafka;

import com.patien.mspatien.DTO.RendezVousEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaObjectMessageProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendObjectMessage(RendezVousEvent event) {
        kafkaTemplate.send("patient-object-topic", event);
        System.out.println("Message Kafka envoyé (asynchrone): " + event);
    }
}