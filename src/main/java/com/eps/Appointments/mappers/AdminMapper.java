package com.eps.Appointments.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.eps.Appointments.DTOs.AdminDTO;
import com.eps.Appointments.persistance.entities.Admin;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "password", target = "password")
    AdminDTO toAdminDTO (Admin admin);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Admin toAdmin (AdminDTO adminDTO);
    
}
