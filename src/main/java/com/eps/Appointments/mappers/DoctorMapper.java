package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.DoctorDTO;
import com.eps.Appointments.persistance.entities.Doctor;

@Mapper(componentModel = "spring", uses = {HeadquarterMapper.class, SpecializationMapper.class})
public interface DoctorMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "headquarter", target = "headquarter")
    @Mapping(source = "specialization", target = "specialization")
    DoctorDTO toDoctorDTO (Doctor doctor);

    @InheritInverseConfiguration
    Doctor toDoctor (DoctorDTO doctor);
}
