package com.rendezvous.rendezvous.Controller;

import com.rendezvous.rendezvous.DTO.RendezVousRequestDto;
import com.rendezvous.rendezvous.DTO.RendezVousResponseDto;
import com.rendezvous.rendezvous.Service.RendezVousService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rendezvous")
@RequiredArgsConstructor
public class RendezVousController {

    private final RendezVousService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RendezVousResponseDto create(@Valid @RequestBody RendezVousRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public RendezVousResponseDto getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<RendezVousResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/patient/{patientId}")
    public List<RendezVousResponseDto> getByPatientId(@PathVariable Long patientId) {
        return service.getByPatientId(patientId);
    }

    @PutMapping("/{id}")
    public RendezVousResponseDto update(
            @PathVariable String id,
            @Valid @RequestBody RendezVousRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}