package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.persistance.entities.Date;

@Mapper(componentModel = "spring")
public interface DateMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "Datetype", target = "datetype")
    @Mapping(source = "Headquarter", target = "headquarter")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "LocalDateTime.initialTime", target = "initialTime")
    @Mapping(source = "LocalDateTime.finalTime", target = "finalTime")
    @Mapping(source = "LocalDate.date", target = "date")
    @Mapping(source = "status", target = "status")

    DateDTO toDateDto (Date date);

    @InheritInverseConfiguration
    @Mapping(target = "LocalDateTime", ignore = true)
    @Mapping(target = "LocalDate", ignore = true)
    Date toDate (DateDTO dateDTO);
    
}
