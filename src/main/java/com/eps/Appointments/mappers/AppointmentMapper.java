package com.eps.Appointments.mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.AppointmentDTO;
import com.eps.Appointments.persistance.entities.Appointment;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, PatientMapper.class, DateMapper.class})
public interface AppointmentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "doctor", target = "doctor")
    @Mapping(source = "patient", target = "patient")
    @Mapping(source = "date", target = "date")
    AppointmentDTO toAppointmentDTO (Appointment appointment);

    @InheritInverseConfiguration
    Appointment toAppointment (AppointmentDTO appointmentDTO);
}
