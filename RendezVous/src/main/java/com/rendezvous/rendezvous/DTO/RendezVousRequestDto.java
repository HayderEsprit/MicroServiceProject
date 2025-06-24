package com.rendezvous.rendezvous.DTO;



import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record RendezVousRequestDto(
        @NotNull(message = "L'ID patient est obligatoire")
        Long patientId,

        @Future(message = "La date doit être dans le futur")
        LocalDateTime dateRdv,

        @NotBlank(message = "La description est obligatoire")
        String description
) {}