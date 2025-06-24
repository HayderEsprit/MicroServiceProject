package com.rendezvous.rendezvous.Service;

import com.rendezvous.rendezvous.DTO.RendezVousRequestDto;
import com.rendezvous.rendezvous.DTO.RendezVousResponseDto;
import com.rendezvous.rendezvous.Entity.RendezVous;
import com.rendezvous.rendezvous.Exception.RendezVousNotFoundException;
import com.rendezvous.rendezvous.Mapper.RendezVousMapper;
import com.rendezvous.rendezvous.Repository.RendezVousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RendezVousServiceImpl implements RendezVousService {

    private final RendezVousRepository repository;
    private final RendezVousMapper mapper;

    @Override
    public RendezVousResponseDto create(RendezVousRequestDto dto) {
        RendezVous rdv = mapper.toEntity(dto);
        return mapper.toDto(repository.save(rdv));
    }

    @Override
    public RendezVousResponseDto getById(String id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new RendezVousNotFoundException(id)));
    }

    @Override
    public List<RendezVousResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<RendezVousResponseDto> getByPatientId(Long patientId) {
        return repository.findByPatientId(patientId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public RendezVousResponseDto update(String id, RendezVousRequestDto dto) {
        RendezVous existing = repository.findById(id)
                .orElseThrow(() -> new RendezVousNotFoundException(id));
        mapper.updateEntity(dto, existing);
        return mapper.toDto(repository.save(existing));
    }

    @Override
    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new RendezVousNotFoundException(id);
        }
        repository.deleteById(id);
    }
}