package com.rendezvous.rendezvous.Service;

import com.rendezvous.rendezvous.DTO.RendezVousRequestDto;
import com.rendezvous.rendezvous.DTO.RendezVousResponseDto;

import java.util.List;

public interface RendezVousService {
    RendezVousResponseDto create(RendezVousRequestDto dto);
    RendezVousResponseDto getById(String id);
    List<RendezVousResponseDto> getAll();
    List<RendezVousResponseDto> getByPatientId(Long patientId);
    RendezVousResponseDto update(String id, RendezVousRequestDto dto);
    void delete(String id);
}