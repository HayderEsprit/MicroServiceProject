package com.patien.mspatien.Service;

import com.patien.mspatien.DTO.PatientRequestDto;
import com.patien.mspatien.DTO.PatientResponseDto;
import com.patien.mspatien.DTO.PatientWithRendezVousDto;
import com.patien.mspatien.DTO.RendezVousResponseDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

public interface PatientService {
    PatientResponseDto savePatient(PatientRequestDto patientRequestDto);
    PatientResponseDto getPatient(Long id);
    List<PatientResponseDto> getAllPatients();
    PatientResponseDto updatePatient(Long id, PatientRequestDto patientRequestDto);
    void deletePatient(Long id);

    PatientWithRendezVousDto PatientWithRendezVousDtoSansCircuitBreaker(Long patientId);


    @CircuitBreaker(name = "rendezvousService", fallbackMethod = "fallbackPatientWithRendezVous")
    PatientWithRendezVousDto PatientWithRendezVousDtoAvecCircuitBreaker(Long patientId);

    // Fallback si le service est down
}