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
import com.eps.Appointments.DTOs.IdTypeDTO;
import com.eps.Appointments.persistance.entities.IdType;
/**
* public name interface IdTypeMapper
* @mapper geographic information system (GIS)
**/
@Mapper(componentModel = "spring")
public interface IdTypeMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "type", target = "type")
    IdTypeDTO toIdTypeDTO (IdType idType);

    @InheritInverseConfiguration
    IdType toIdType (IdTypeDTO idTypeDTO);
    
}
