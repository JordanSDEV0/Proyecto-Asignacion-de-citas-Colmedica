package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.SpecializationDTO;
import com.eps.Appointments.persistance.entities.Specialization;

@Mapper(componentModel = "spring")
public interface SpecializationMapper {

    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    SpecializationDTO toSpecializationDTO (Specialization specialization);

    @InheritInverseConfiguration
    Specialization toSpecialization (SpecializationDTO specializationDTO);
    
    
}
