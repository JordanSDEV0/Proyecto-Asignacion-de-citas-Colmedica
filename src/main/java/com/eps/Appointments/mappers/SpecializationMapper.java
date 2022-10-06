package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.SpecializationDTO;
import com.eps.Appointments.persistance.entities.Specialization;


@Mapper(componentModel = "spring")
public interface SpecializationMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "idtype", target = "idtype")
    SpecializationDTO toSpecializationDTO (Specialization specialization);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Specialization toSpecialization (SpecializationDTO specializationDTO);
    
    
}
