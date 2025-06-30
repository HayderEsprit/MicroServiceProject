package com.patien.mspatien.Kafka;

import com.patien.mspatien.DTO.PatientDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KafkaLogger {

    private static final String SEPARATOR = "=".repeat(50);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logPatientSent(PatientDTO patientDTO) {
        System.out.println(SEPARATOR);
        System.out.println("🚀 ENVOI PATIENT VERS KAFKA");
        System.out.println("Timestamp: " + LocalDateTime.now().format(formatter));
        System.out.println("Topic: patient-topic");
        logPatientDetails(patientDTO);
        System.out.println(SEPARATOR);
    }

    public static void logPatientReceived(PatientDTO patientDTO) {
        System.out.println(SEPARATOR);
        System.out.println("📨 RÉCEPTION PATIENT DEPUIS KAFKA");
        System.out.println("Timestamp: " + LocalDateTime.now().format(formatter));
        System.out.println("Topic: patient-topic");
        System.out.println("Group: rendezvous-group");
        logPatientDetails(patientDTO);
        System.out.println(SEPARATOR);
    }

    public static void logPatientProcessing(PatientDTO patientDTO) {
        System.out.println(SEPARATOR);
        System.out.println("⚙️ TRAITEMENT PATIENT EN COURS");
        System.out.println("Timestamp: " + LocalDateTime.now().format(formatter));
        logPatientDetails(patientDTO);
        System.out.println("Status: En cours de traitement...");
        System.out.println(SEPARATOR);
    }

    private static void logPatientDetails(PatientDTO patientDTO) {
        System.out.println("📋 DÉTAILS DU PATIENT:");
        System.out.println("├── ID: " + (patientDTO.getId() != null ? patientDTO.getId() : "Non défini"));
        System.out.println("├── Nom: " + (patientDTO.getNom() != null ? patientDTO.getNom() : "Non défini"));
        System.out.println("├── Prénom: " + (patientDTO.getPrenom() != null ? patientDTO.getPrenom() : "Non défini"));
        System.out.println("└── Email: " + (patientDTO.getEmail() != null ? patientDTO.getEmail() : "Non défini"));
        System.out.println("JSON: " + patientDTO.toString());
    }
}