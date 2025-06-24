package com.patien.mspatien.Service;

import com.patien.mspatien.DTO.PatientRequestDto;
import com.patien.mspatien.DTO.PatientResponseDto;
import com.patien.mspatien.DTO.PatientWithRendezVousDto;
import com.patien.mspatien.DTO.RendezVousResponseDto;
import com.patien.mspatien.Entity.Patient;
import com.patien.mspatien.Exception.PatientNotFoundException;
import com.patien.mspatien.FeignClient.RendezVousClient;
import com.patien.mspatien.Mapper.PatientMapper;
import com.patien.mspatien.Repository.PatientRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final RendezVousClient rendezVousClient;


    @Override
    public PatientResponseDto savePatient(PatientRequestDto patientRequestDto) {
        Patient patient = patientMapper.toEntity(patientRequestDto);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toResponseDto(savedPatient);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientResponseDto getPatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));
        return patientMapper.toResponseDto(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientResponseDto> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PatientResponseDto updatePatient(Long id, PatientRequestDto patientRequestDto) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));

        existingPatient.setNom(patientRequestDto.nom());
        existingPatient.setPrenom(patientRequestDto.prenom());
        existingPatient.setEmail(patientRequestDto.email());
        existingPatient.setTel(patientRequestDto.tel());

        Patient updatedPatient = patientRepository.save(existingPatient);
        return patientMapper.toResponseDto(updatedPatient);
    }

    @Override
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException(id);
        }
        patientRepository.deleteById(id);
    }


   @Override
   public PatientWithRendezVousDto PatientWithRendezVousDtoSansCircuitBreaker(Long patientId) {
       // 1. Récupérer le patient en utilisant votre méthode existante toResponseDto()
       PatientResponseDto patient = patientMapper.toResponseDto(
               patientRepository.findById(patientId)
                       .orElseThrow(() -> new PatientNotFoundException(patientId))
       );

       // 2. Appeler le service RendezVous
       List<RendezVousResponseDto> rendezVous = rendezVousClient.getRendezVousByPatientId(patientId);

       // 3. Retourner les données combinées
       return new PatientWithRendezVousDto(patient, rendezVous);
   }
    @CircuitBreaker(name = "rendezvousService", fallbackMethod = "fallbackPatientWithRendezVous")
    @Override
    public PatientWithRendezVousDto PatientWithRendezVousDtoAvecCircuitBreaker(Long patientId) {
        PatientResponseDto patient = patientMapper.toResponseDto(
                patientRepository.findById(patientId)
                        .orElseThrow(() -> new PatientNotFoundException(patientId))
        );

        List<RendezVousResponseDto> rendezVous = rendezVousClient.getRendezVousByPatientId(patientId);

        return new PatientWithRendezVousDto(patient, rendezVous);
}


    // La méthode fallback correspondante
    public PatientWithRendezVousDto fallbackPatientWithRendezVous(Long patientId, Throwable t) {
        System.out.println("⚠️ Fallback activé pour le patient " + patientId + " à cause de : " + t);

        PatientResponseDto patient = patientMapper.toResponseDto(
                patientRepository.findById(patientId)
                        .orElseThrow(() -> new PatientNotFoundException(patientId))
        );

        return new PatientWithRendezVousDto(patient, List.of()); // Liste vide
    }




}
