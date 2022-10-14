/**
* Package with which the persistence of the mappers is accessed
**/
package com.eps.Appointments.mappers;
/**
* Imports of mapstruct
*/
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.CertificateDTO;
import com.eps.Appointments.persistance.entities.Certificate;
/**
* public name interface CertificateMapper
* @mapper geographic information system (GIS)
**/
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
