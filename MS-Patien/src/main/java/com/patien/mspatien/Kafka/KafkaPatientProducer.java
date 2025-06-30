package com.patien.mspatien.Kafka;

import com.patien.mspatien.DTO.PatientDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPatientProducer {

    private final KafkaTemplate<String, PatientDTO> kafkaTemplate;

    public KafkaPatientProducer(KafkaTemplate<String, PatientDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPatientMessage(PatientDTO patientDTO) {
        kafkaTemplate.send("patient-topic", patientDTO);
        System.out.println("PatientDTO envoyé: " + patientDTO.toString());
    }
}