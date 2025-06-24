package com.patien.mspatien.Mapper;

import com.patien.mspatien.DTO.PatientRequestDto;
import com.patien.mspatien.DTO.PatientResponseDto;
import com.patien.mspatien.Entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientRequestDto patientRequestDto);
    PatientResponseDto toResponseDto(Patient patient);
}