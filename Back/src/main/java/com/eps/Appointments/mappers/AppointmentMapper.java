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
    @Mapping(source = "doctor", target = "doctorId")
    @Mapping(source = "patient", target = "patientId")
    @Mapping(source = "date", target = "dateId")
    AppointmentDTO toAppointmentDTO (Appointment appointment);
    
    default Doctor mapDoctor(String id){
        Doctor d= new Doctor();
        d.setId(id);
        return d;
    }
    
    default Patient mapPatient(String id){
        Patient d= new Patient();
        d.setId(id);
        return d;
    }
    
    default Date mapDate(String id){
        Date d= new Date();
        d.setId(id);
        return d;
    }
    
    default String mapDoctor(Doctor doctor){
        return doctor.getId();
    }
    
    default String mapPatient(Patient doctor){
        return doctor.getId();
    }
    
    default int mapDate(Date doctor){
        return doctor.getId();
    }

    @InheritInverseConfiguration
    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "date", ignore = true)
    Appointment toAppointment (AppointmentDTO appointmentDTO);

    List<AppointmentDTO> toAppointmentDTOs(List<Appointment> appointments);

}
