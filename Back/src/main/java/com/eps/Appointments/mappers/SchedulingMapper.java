package com.eps.Appointments.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.SchedulingDTO;
import com.eps.Appointments.DTOs.DateDTO;
import com.eps.Appointments.DTOs.AppointmentDTO;

@Mapper(componentModel = "spring")
public interface SchedulingMapper {
    
    @Mapping(source = "dateTypeId", target = "dateTypeId")
    @Mapping(source = "headquarterId", target = "headquarterId")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "initialTime", target = "initialTime")
    @Mapping(source = "finalTime", target = "finalTime")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "status", target = "status")
    DateDTO toDateDto (SchedulingDTO scheduling);

    @Mapping(source = "doctorId", target = "doctorId")
    @Mapping(source = "patientId", target = "patientId")
    @Mapping(source = "dateId", target = "dateId")  
    AppointmentDTO toAppointmentDTO (SchedulingDTO scheduling);
    
}
