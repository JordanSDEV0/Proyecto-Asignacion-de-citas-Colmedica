package com.eps.Appointments.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.AdminDTO;
import com.eps.Appointments.persistance.entities.Admin;

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
