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
import com.eps.Appointments.persistance.entities.Occupation;
import com.eps.Appointments.persistance.entities.Patient;

/**
 * public name interface PatientMapper
 *
 * @mapper geographic information system (GIS)
 **/
@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(source = "idType", target = "idTypeId")
    @Mapping(source = "headquarter", target = "headquarterId")
    @Mapping(source = "occupation", target = "occupationId")
    PatientDTO toPatientDTO(Patient patient);

    default int mapIdType(IdType idType) {
        return idType.getId();
    }

    default int mapHeadquarter(Headquarter headquarter) {
        return headquarter.getId();
    }

    default int mapOccupation(Occupation occupation) {
        return occupation.getId();
    }

    default IdType mapIdType(int id) {
        IdType idType = new IdType();
        idType.setId(id);
        return idType;
    }

    default Headquarter mapHeadquarter(int id) {
        Headquarter headquarter = new Headquarter();
        headquarter.setId(id);
        return headquarter;
    }

    default Occupation mapOccupation(int id) {
        Occupation occupation = new Occupation();
        occupation.setId(id);
        return occupation;
    }

    /**
     * Advises the code generator to apply all the Mapping s from an inverse mapping
     * method to the annotated method as well
     **/
    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Patient toPatient(PatientDTO patientDTO);

    List<PatientDTO> toPatientDTOs(List<Patient> patient);

}
