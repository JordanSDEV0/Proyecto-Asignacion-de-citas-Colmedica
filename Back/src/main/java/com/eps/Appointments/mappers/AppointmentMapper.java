/**
* Package with which the persistence of the mappers is accessed
**/
package com.eps.Appointments.mappers;

import java.util.ArrayList;
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
import com.eps.Appointments.persistance.entities.DateType;
import com.eps.Appointments.persistance.entities.Doctor;
import com.eps.Appointments.persistance.entities.Headquarter;
import com.eps.Appointments.persistance.entities.MedicalDate;
import com.eps.Appointments.persistance.entities.Patient;

/**
 * public name interface AppointmentMapper
 *
 * @mapper geographic information system (GIS)
 **/
@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "appointment.id", target = "id")
    @Mapping(source = "appointment.doctor.id", target = "doctorId")
    @Mapping(source = "appointment.patient.id", target = "patientId")
    @Mapping(source = "medicalDate.id", target = "dateId")
    @Mapping(source = "medicalDate.dateType.id", target = "dateTypeId")
    @Mapping(source = "medicalDate.headquarter.id", target = "headquarterId")
    @Mapping(source = "medicalDate.date", target = "date")
    AppointmentDTO toAppointmentDTO(Appointment appointment, MedicalDate medicalDate);

    @InheritInverseConfiguration
    @Mapping(source = "doctorId", target = "doctor")
    @Mapping(source = "patientId", target = "patient")
    @Mapping(source = "dateId", target = "date")
    Appointment toAppointment(AppointmentDTO appointmentDTO);

    default Doctor mapDoctor(String id) {
        Doctor doctor = new Doctor();
        doctor.setId(id);
        return doctor;
    }

    default Patient mapPatient(String id) {
        Patient patient = new Patient();
        patient.setId(id);
        return patient;
    }

    default MedicalDate mapMedicalDate(int id) {
        MedicalDate medicalDate = new MedicalDate();
        medicalDate.setId(id);
        return medicalDate;
    }

    @InheritInverseConfiguration
    @Mapping(source = "headquarterId", target = "headquarter")
    @Mapping(source = "dateTypeId", target = "dateType")
    MedicalDate toMedicalDate(AppointmentDTO appointmentDTO);

    default DateType mapDateType(int id) {
        DateType dateType = new DateType();
        dateType.setId(id);
        return dateType;
    }

    default Headquarter mapHeadquarter(int id) {
        Headquarter headquarter = new Headquarter();
        headquarter.setId(id);
        return headquarter;
    }

    default List<AppointmentDTO> toAppointmentDTOs(List<Appointment> appointments, List<MedicalDate> medicalDates) {
        List<AppointmentDTO> appointmentDTOs = new ArrayList<>();
        for (int index = 0; index < appointments.size(); index++) {
            Appointment a = appointments.get(index);
            MedicalDate m = medicalDates.get(index);
            appointmentDTOs.add(new AppointmentDTO(a.getId(), a.getDoctor().getId(), a.getPatient().getId(), m.getId(),
                    m.getDateType().getId(), m.getHeadquarter().getId(), m.getDescription(), m.getInitialTime(),
                    m.getFinalTime(), m.getDate(), m.getStatus()));
        }
        return appointmentDTOs;
    }

}
