package com.patien.mspatien.FeignClient;

import com.patien.mspatien.DTO.RendezVousResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "rendezvous-service",
        url = "${rendezvous.service.url:http://localhost:8082}"
     //   fallback = RendezVousClientFallback.class// Configurable via bootstrap.yml


)
public interface RendezVousClient {
    @GetMapping("/api/rendezvous/patient/{patientId}")
    List<RendezVousResponseDto> getRendezVousByPatientId(@PathVariable Long patientId);
}