package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.HeadquarterDTO;
import com.eps.Appointments.persistance.entities.Headquarter;





@Mapper(componentModel = "spring")
public interface HeadquarterMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "City.city", target = "city")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    HeadquarterDTO toHeadquarterDTO (Headquarter Headquarter);

    @InheritInverseConfiguration
    @Mapping(target = "City", ignore = true)
    Headquarter toHeadquarter (HeadquarterDTO headquarterDTO);
    
}