package com.rendezvous.rendezvous.Kafka;

import com.rendezvous.rendezvous.DTO.PatientDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaPatientConsumer {

    @KafkaListener(topics = "patient-topic", groupId = "rendezvous-group")
    public void consumePatientMessage(PatientDTO patientDTO) {
        System.out.println("PatientDTO reçu depuis Kafka: " + patientDTO.toString());

        // Traitement du PatientDTO
        processPatient(patientDTO);
    }


    private void processPatient(PatientDTO patientDTO) {
        // Votre logique de traitement ici
        System.out.println("Traitement du patient: " + patientDTO.getNom() + " " + patientDTO.getPrenom());
        // Ex: enregistrer le rendez-vous lié à ce patient
    }
}
