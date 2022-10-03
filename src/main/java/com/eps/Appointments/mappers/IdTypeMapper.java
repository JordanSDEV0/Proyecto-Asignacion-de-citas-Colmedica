package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.IdTypeDTO;
import com.eps.Appointments.persistance.entities.IdType;


@Mapper(componentModel = "spring")
public interface IdTypeMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "type", target = "type")
    IdTypeDTO toIdTypeDTO (IdType idType);

    @InheritInverseConfiguration
    IdType toIdType (IdTypeDTO idTypeDTO);
    
}
