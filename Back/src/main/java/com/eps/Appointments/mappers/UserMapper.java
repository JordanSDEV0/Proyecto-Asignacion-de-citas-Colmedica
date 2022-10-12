package com.eps.Appointments.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.UserDTO;
import com.eps.Appointments.persistance.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "password", target = "password")
    UserDTO toUserDTO (User user);

    @InheritInverseConfiguration
    User toUser (UserDTO userDTO);

     List<UserDTO> toUserDTOs(List<User> user);
     
    
}
