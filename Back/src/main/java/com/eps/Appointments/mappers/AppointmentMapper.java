package com.eps.Appointments.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eps.Appointments.DTOs.AppointmentDTO;
import com.eps.Appointments.persistance.entities.Appointment;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, PatientMapper.class, DateMapper.class})
public interface AppointmentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "date.id", target = "dateId")
    AppointmentDTO toAppointmentDTO (Appointment appointment);
    
    @InheritInverseConfiguration
    Appointment toAppointment (AppointmentDTO appointmentDTO);

    List<AppointmentDTO> toAppointmentDTOs(List<Appointment> appointments);

}
