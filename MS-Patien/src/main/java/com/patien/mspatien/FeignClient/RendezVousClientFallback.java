package com.patien.mspatien.FeignClient;

import com.patien.mspatien.DTO.RendezVousResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RendezVousClientFallback implements RendezVousClient {

    @Override
    public List<RendezVousResponseDto> getRendezVousByPatientId(Long patientId) {
        System.err.println("🚨 Fallback activé : rendezvous-service indisponible pour patientId = " + patientId);
        return List.of(); // retourne une liste vide
    }
}