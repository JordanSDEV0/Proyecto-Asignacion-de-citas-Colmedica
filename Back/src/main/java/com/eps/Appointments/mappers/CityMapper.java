/**
* Package with which the persistence of the mappers is accessed
**/
package com.eps.Appointments.mappers;
/**
* Imports of mapstruct
*/
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
* Imports of apposintments
*/
import com.eps.Appointments.DTOs.CityDTO;
import com.eps.Appointments.persistance.entities.City;
/**
* public name interface CityMapper
* @mapper geographic information system (GIS)
**/
@Mapper(componentModel = "spring", uses = DepartmentMapper.class)
public interface CityMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "department", target = "department")
    @Mapping(source = "city", target = "city")
    CityDTO toCertificateDTO (City city);

    @InheritInverseConfiguration
    City toCity (CityDTO cityDTO);
}
