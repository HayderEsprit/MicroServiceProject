package com.patien.mspatien.DTO;

public record PatientResponseDto(
        Long id,
        String nom,
        String prenom,
        String email,
        String tel
) {}