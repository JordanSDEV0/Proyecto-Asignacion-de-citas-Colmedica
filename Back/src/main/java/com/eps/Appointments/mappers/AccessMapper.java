/**
* Package with which the persistence of the mappers is accessed
**/
package com.eps.Appointments.mappers;

/**
* Imports of mapstruct
*/
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.AccessDTO;
import com.eps.Appointments.persistance.entities.Access;

/**
 * public name interface AccessMapper
 *
 * @mapper geographic information system (GIS)
 **/
@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface AccessMapper {

    AccessDTO toAccessDTO(Access access);

    @InheritInverseConfiguration
    Access toAccess(AccessDTO accessDTO);

}
