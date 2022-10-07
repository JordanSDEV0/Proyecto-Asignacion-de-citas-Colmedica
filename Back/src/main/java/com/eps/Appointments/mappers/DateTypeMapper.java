package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.DateTypeDTO;
import com.eps.Appointments.persistance.entities.DateType;

@Mapper(componentModel = "spring")
public interface DateTypeMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    DateTypeDTO toDateTypeDTO (DateType dateType);

    @InheritInverseConfiguration
    DateType toDateType (DateTypeDTO dateTypeDTO);
}
