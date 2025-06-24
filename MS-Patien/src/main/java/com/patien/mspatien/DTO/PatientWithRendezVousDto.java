package com.patien.mspatien.DTO;

import java.util.List;

public record PatientWithRendezVousDto(
        PatientResponseDto patient,
        List<RendezVousResponseDto> rendezVous
) {}