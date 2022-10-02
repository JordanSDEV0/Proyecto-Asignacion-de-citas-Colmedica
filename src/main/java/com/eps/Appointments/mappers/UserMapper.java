package com.eps.Appointments.mappers;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.UserDTO;
import com.eps.Appointments.persistance.entities.Admin;
import com.eps.Appointments.persistance.entities.User;

public interface UserMapper {
    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "password", target = "password")
    UserDTO toUserDTO (User user);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    User toUser (UserDTO userDTO);
    

}
