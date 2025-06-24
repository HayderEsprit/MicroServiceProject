package com.rendezvous.rendezvous.DTO;



import java.time.LocalDateTime;

public record RendezVousResponseDto(
        String id,
        Long patientId,
        LocalDateTime dateRdv,
        String description
) {}