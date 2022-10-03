package com.eps.Appointments.mappers;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.PatientDTO;
import com.eps.Appointments.persistance.entities.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "idtype", target = "idtype")
    @Mapping(source = "headquarter", target = "headquarter")
    @Mapping(source = "ocupation", target = "ocupation")
    @Mapping(source = "regimenType", target = "regimenType")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "genre", target = "genre")
    PatientDTO toPatientDTO (Patient patient);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Patient toPatient (PatientDTO patientDTO);
    
}
