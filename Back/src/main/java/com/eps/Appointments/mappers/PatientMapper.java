package com.eps.Appointments.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.PatientDTO;
import com.eps.Appointments.persistance.entities.Headquarter;
import com.eps.Appointments.persistance.entities.IdType;
import com.eps.Appointments.persistance.entities.Ocupation;
import com.eps.Appointments.persistance.entities.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.password", target = "password")
    @Mapping(source = "idType", target = "idTypeId")
    @Mapping(source = "headquarter", target = "headquarterId")
    @Mapping(source = "ocupation", target = "ocupationId")
    @Mapping(source = "regimenType", target = "regimenType")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "genre", target = "genre")
    PatientDTO toPatientDTO (Patient patient);

    default int mapIdType(IdType idType){
        return idType.getId();
    }

    default int mapHeadquarter(Headquarter headquarter){
        return headquarter.getId();
    }

    default int mapOcupation(Ocupation ocupation){
        return ocupation.getId();
    }

    default IdType mapIdType(int id){
        IdType idType= new IdType();
        idType.setId(id);
        return idType;
    }

    default Headquarter mapHeadquarter(int id){
        Headquarter headquarter= new Headquarter();
        headquarter.setId(id);
        return headquarter;
    }
    default Ocupation mapOcupation(int id){
        Ocupation ocupation= new Ocupation();
        ocupation.setId(id);
        return ocupation;
    }
    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Patient toPatient (PatientDTO patientDTO);

    
}
