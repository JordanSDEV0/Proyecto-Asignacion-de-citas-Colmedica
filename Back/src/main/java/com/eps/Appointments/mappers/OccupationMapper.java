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
import com.eps.Appointments.DTOs.OccupationDTO;
import com.eps.Appointments.persistance.entities.Occupation;

/**
 * public name interface OcupationMapper
 * 
 * @mapper geographic information system (GIS)
 **/
@Mapper(componentModel = "spring")
public interface OccupationMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "occupation", target = "occupation")
    OccupationDTO toOccupationDTO(Occupation occupation);

    @InheritInverseConfiguration
    Occupation toOccupation(OccupationDTO occupationDTO);

    List<OccupationDTO> toOccupationDTOs(List<Occupation> occupation);
}
