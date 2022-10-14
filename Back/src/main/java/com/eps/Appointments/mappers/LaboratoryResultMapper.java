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
import com.eps.Appointments.DTOs.LaboratoryResultDTO;
import com.eps.Appointments.persistance.entities.LaboratoryResult;
/**
* public name interface LaboratoryResultMapper
* @mapper geographic information system (GIS)
**/
@Mapper(componentModel = "spring", uses = DateMapper.class)
public interface LaboratoryResultMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "archiveRute", target = "archiveRute")
    LaboratoryResultDTO toLaboratoryResultDTO (LaboratoryResult laboratoryResult);

    @InheritInverseConfiguration
    LaboratoryResult toLaboratoryResult (LaboratoryResultDTO laboratoryResultDTO);
}
