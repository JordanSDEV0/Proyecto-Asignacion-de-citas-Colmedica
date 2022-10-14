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
import com.eps.Appointments.DTOs.OcupationDTO;
import com.eps.Appointments.persistance.entities.Ocupation;
/**
* public name interface OcupationMapper
* @mapper geographic information system (GIS)
**/
@Mapper(componentModel = "spring")
public interface OcupationMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "ocupation", target = "ocupation")
    OcupationDTO toOcupationDTO (Ocupation ocupation);

    @InheritInverseConfiguration
    Ocupation toOcupation (OcupationDTO ocupationDTO);

    List<OcupationDTO> toOcupationDTOs(List<Ocupation> ocupation);
}
