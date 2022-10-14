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
import com.eps.Appointments.DTOs.AdminDTO;
import com.eps.Appointments.persistance.entities.Admin;
/**
* public name interface AdminMapper
* @mapper geographic information system (GIS)
**/
@Mapper(componentModel = "spring")
public interface AdminMapper {

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "password", target = "password")
    AdminDTO toAdminDTO (Admin admin);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Admin toAdmin (AdminDTO adminDTO);

    List<AdminDTO> toAdminDTOs(List<Admin> admin);
    
}
