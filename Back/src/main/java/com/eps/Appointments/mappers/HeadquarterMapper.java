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
import com.eps.Appointments.DTOs.HeadquarterDTO;
import com.eps.Appointments.persistance.entities.Headquarter;
/**
* public name interface HeadquarterMapper
* @mapper geographic information system (GIS)
**/
@Mapper(componentModel = "spring", uses = CityMapper.class)
public interface HeadquarterMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    HeadquarterDTO toHeadquarterDTO (Headquarter Headquarter);

    List<HeadquarterDTO> toHeadquarterDTOs(List<Headquarter> Headquarters);

    @InheritInverseConfiguration
    Headquarter toHeadquarter (HeadquarterDTO headquarterDTO);
    
}
