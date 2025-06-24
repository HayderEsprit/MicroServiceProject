package com.patien.mspatien.DTO;

import java.time.LocalDateTime;

public record RendezVousEvent(
        Long patientId,
        String eventType,
        LocalDateTime timestamp
) {}