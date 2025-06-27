package com.rendezvous.rendezvous.Kafka;



import com.rendezvous.rendezvous.DTO.RendezVousEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    @KafkaListener(
            topics = "patient-text-topic",
            groupId = "group-1",
            containerFactory = "textKafkaListenerFactory"  // OK
    )
    public void consumeText(String message) {
        System.out.println("🟢 Texte reçu de Kafka: " + message);
    }


//    @KafkaListener(topics = "patient-object-topic", groupId = "group-1", containerFactory = "objectKafkaListenerFactory")
//    public void consumeObject(RendezVousEvent event) {
//        System.out.println("🟢 Objet reçu de Kafka: " + event);
//    }
}
