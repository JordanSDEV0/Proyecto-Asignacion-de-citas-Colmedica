package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.CityDTO;
import com.eps.Appointments.persistance.entities.City;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "Department.department", target = "department")
    @Mapping(source = "city", target = "city")
    CityDTO toCertificateDTO (City city);

    @InheritInverseConfiguration
    @Mapping(target = "Department", ignore = true)
    City toCity (CityDTO cityDTO);
}
