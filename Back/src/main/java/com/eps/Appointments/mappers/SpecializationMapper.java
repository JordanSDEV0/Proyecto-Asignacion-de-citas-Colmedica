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
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.SpecializationDTO;
import com.eps.Appointments.persistance.entities.Specialization;
/**
* public name interface SpecializationMapper
* @mapper geographic information system (GIS)
**/
@Mapper(componentModel = "spring")
public interface SpecializationMapper {
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    SpecializationDTO toSpecializationDTO (Specialization specialization);

    @InheritInverseConfiguration
    Specialization toSpecialization (SpecializationDTO specializationDTO);
}
