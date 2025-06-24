package com.rendezvous.rendezvous.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rendezvous")
public class RendezVous {
    public RendezVous(Long patientId, String id) {
        this.patientId = patientId;
        this.id = id;
    }
    @Id
    private String id;

    private Long patientId; // ID venant du microservice Patient (UUID ou Long)

    private LocalDateTime dateRdv;
    private String description;

}

