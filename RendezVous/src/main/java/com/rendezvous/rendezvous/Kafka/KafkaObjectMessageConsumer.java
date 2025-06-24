package com.rendezvous.rendezvous.Kafka;

import com.rendezvous.rendezvous.DTO.RendezVousEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaObjectMessageConsumer {

//    /@KafkaListener(
//            topics = "patient-object-topic",
//            groupId = "group-1",
//            containerFactory = "kafkaListenerContainerFactory"
//    )
//    public void consumeObjectMessage(RendezVousEvent event) {
//        System.out.println("Objet reçu - Patient ID: " + event.patientId());
//        // Traitez l'objet ici
//    }
//
}