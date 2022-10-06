package com.eps.Appointments.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.CertificateDTO;
import com.eps.Appointments.persistance.entities.Certificate;

@Mapper(componentModel = "spring", uses= PatientMapper.class)
public interface CertificateMapper {
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "patient", target = "patient")
    @Mapping(source = "rute", target = "rute")
    @Mapping(source = "type", target = "type")
    CertificateDTO toCertificateDTO (Certificate certificate);

    @InheritInverseConfiguration
    Certificate toCertificate (CertificateDTO certificateDTO);

}
