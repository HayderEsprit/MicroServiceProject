package com.patien.mspatien.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PatientRequestDto(
        @NotBlank(message = "Le nom est obligatoire")
        @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
        String nom,

        @NotBlank(message = "Le prénom est obligatoire")
        @Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères")
        String prenom,

        @NotBlank(message = "L'email est obligatoire")
        @Email(message = "L'email doit être valide")
        String email,

        @NotBlank(message = "Le téléphone est obligatoire")
        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Numéro invalide")
        String tel
) {}