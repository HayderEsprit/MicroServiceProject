package com.rendezvous.rendezvous.Mapper;




import com.rendezvous.rendezvous.DTO.RendezVousRequestDto;
import com.rendezvous.rendezvous.DTO.RendezVousResponseDto;
import com.rendezvous.rendezvous.Entity.RendezVous;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RendezVousMapper {
    RendezVous toEntity(RendezVousRequestDto dto);
    RendezVousResponseDto toDto(RendezVous entity);
    void updateEntity(RendezVousRequestDto dto, @MappingTarget RendezVous entity);
}