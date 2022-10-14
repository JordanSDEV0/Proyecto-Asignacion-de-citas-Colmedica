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
* Imports of appointments
*/
import com.eps.Appointments.DTOs.AppointmentDTO;
import com.eps.Appointments.persistance.entities.Appointment;
/**
* public name interface AppointmentMapper
* @mapper geographic information system (GIS)
**/
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
