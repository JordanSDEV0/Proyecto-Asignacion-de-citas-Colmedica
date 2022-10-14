/**
* Package with which the persistence of the mappers is accessed
**/
package com.eps.Appointments.mappers;
/**
* Imports of java
*/
import java.util.List;
/**
* Imports of mapstruct
*/
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.PatientDTO;
import com.eps.Appointments.persistance.entities.Headquarter;
import com.eps.Appointments.persistance.entities.IdType;
import com.eps.Appointments.persistance.entities.Ocupation;
import com.eps.Appointments.persistance.entities.Patient;
/**
* public name interface PatientMapper
* @mapper geographic information system (GIS)
**/
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
/**
* Advises the code generator to apply all the Mapping s from an inverse mapping method to the annotated method as well
**/
    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Patient toPatient (PatientDTO patientDTO);

    List<PatientDTO> toPatientDTOs(List<Patient> patient);

}
