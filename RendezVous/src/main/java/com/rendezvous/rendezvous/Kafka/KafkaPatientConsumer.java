package com.rendezvous.rendezvous.Kafka;

import com.rendezvous.rendezvous.DTO.PatientDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaPatientConsumer {

    @KafkaListener(topics = "patient-topic", groupId = "rendezvous-group")
    public void consumePatientMessage(PatientDTO patientDTO) {
        System.out.println("=== RÉCEPTION DEPUIS KAFKA ===");
        System.out.println("PatientDTO reçu depuis Kafka:");
        System.out.println("Objet complet: " + patientDTO.toString());
        System.out.println("ID: " + patientDTO.getId());
        System.out.println("Nom: " + patientDTO.getNom());
        System.out.println("Prénom: " + patientDTO.getPrenom());
        System.out.println("Email: " + patientDTO.getEmail());
        System.out.println("===============================");

        // Traitement du PatientDTO
        processPatient(patientDTO);
    }

    private void processPatient(PatientDTO patientDTO) {
        System.out.println("=== TRAITEMENT DU PATIENT ===");
        System.out.println("Début du traitement pour: " + patientDTO.getNom() + " " + patientDTO.getPrenom());
        System.out.println("Email de contact: " + patientDTO.getEmail());

        // Votre logique de traitement ici
        // Ex: enregistrer le rendez-vous lié à ce patient
        // Ex: envoyer un email de confirmation
        // Ex: mettre à jour la base de données

        System.out.println("Traitement terminé avec succès!");
        System.out.println("==============================");
    }
}