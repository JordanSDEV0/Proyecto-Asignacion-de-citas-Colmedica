package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.persistance.entities.Date;

@Mapper(componentModel = "spring", uses = {DateTypeMapper.class, HeadquearterMapper.class})
public interface DateMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "datetype", target = "datetype")
    @Mapping(source = "headquarter", target = "headquarter")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "initialTime", target = "initialTime")
    @Mapping(source = "finalTime", target = "finalTime")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "status", target = "status")
    DateDTO toDateDto (Date date);

    @InheritInverseConfiguration
    Date toDate (DateDTO dateDTO);
    
}
