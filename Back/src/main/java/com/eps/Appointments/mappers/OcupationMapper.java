package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.OcupationDTO;
import com.eps.Appointments.persistance.entities.Ocupation;

@Mapper(componentModel = "spring")
public interface OcupationMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "ocupation", target = "ocupation")
    OcupationDTO toOcupationDTO (Ocupation ocupation);

    @InheritInverseConfiguration
    Ocupation toOcupation (OcupationDTO ocupationDTO);
}
