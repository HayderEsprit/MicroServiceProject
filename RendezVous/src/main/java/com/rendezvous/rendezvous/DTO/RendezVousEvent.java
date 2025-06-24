package com.rendezvous.rendezvous.DTO;

import java.time.LocalDateTime;

public record RendezVousEvent(
        Long patientId,
        String eventType,
        LocalDateTime timestamp
) {}