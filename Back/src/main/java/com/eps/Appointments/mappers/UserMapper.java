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
import com.eps.Appointments.DTOs.UserDTO;
import com.eps.Appointments.persistance.entities.User;

/**
 * public name interface UserMapper
 *
 * @mapper geographic information system (GIS)
 **/
// @Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "rol", target = "rol")

    UserDTO toUserDTO(User user);

    /**
     * Advises the code generator to apply all the Mapping s from an inverse mapping
     * method to the annotated method as well
     **/
    @InheritInverseConfiguration
    User toUser(UserDTO userDTO);

    List<UserDTO> toUserDTOs(List<User> user);

}
