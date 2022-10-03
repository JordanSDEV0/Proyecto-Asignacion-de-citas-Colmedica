package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.CertificateDTO;
import com.eps.Appointments.persistance.entities.Certificate;

@Mapper(componentModel = "spring")
public interface CertificateMapper {
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "patient.id", target = "patient")
    @Mapping(source = "rute", target = "rute")
    @Mapping(source = "type", target = "type")
    CertificateDTO toCertificateDTO (Certificate certificate);

    @InheritInverseConfiguration
    @Mapping(target = "patient", ignore = true)
    Certificate toCertificate (CertificateDTO certificateDTO);
}
