package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.OcupationDTO;
import com.eps.Appointments.persistance.entities.Ocupation;

@Mapper(componentModel = "spring")
public interface OcupationMapper {
    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "ocupation", target = "ocupation")
    OcupationDTO toOcupationDTO (Ocupation ocupation);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Ocupation toOcupation (OcupationDTO ocupationDTO);
}
