package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.AccessDTO;
import com.eps.Appointments.persistance.entities.Access;


@Mapper(componentModel = "spring")
public interface AccessMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.eps", target = "user.eps")
    @Mapping(source = "accessTime", target = "accessTime")
    AccessDTO toAccessDTO (Access access);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Access toAccess (AccessDTO accessDTO);
}
