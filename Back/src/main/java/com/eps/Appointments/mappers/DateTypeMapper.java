/**
* Package with which the persistence of the mappers is accessed
**/
package com.eps.Appointments.mappers;
/**
* Imports of java
*/
import java.util.List;
/**
* Imports of mapstruct
*/
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.DateTypeDTO;
import com.eps.Appointments.persistance.entities.DateType;
/**
* public name interface DateTypeMapper
* @mapper geographic information system (GIS)
**/
@Mapper(componentModel = "spring")
public interface DateTypeMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    DateTypeDTO toDateTypeDTO (DateType dateType);

    List<DateTypeDTO> toDateTypeDTOs (List<DateType> dateTypes);

    @InheritInverseConfiguration
    DateType toDateType (DateTypeDTO dateTypeDTO);
}
