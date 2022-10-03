package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.DoctorDTO;
import com.eps.Appointments.persistance.entities.Doctor;



@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "Headquarter", target = "headquarter")
    @Mapping(source = "Specialization.description", target = "specialization")
    DoctorDTO toDoctorDTO (Doctor doctor);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Doctor toDoctor (DoctorDTO doctor);
}
