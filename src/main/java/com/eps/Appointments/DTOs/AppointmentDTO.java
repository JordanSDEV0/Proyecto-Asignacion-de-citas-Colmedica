package com.eps.Appointments.DTOs;
import com.eps.Appointments.persistance.entities.Date;
import com.eps.Appointments.persistance.entities.Doctor;
import com.eps.Appointments.persistance.entities.Patient;

import lombok.Data;

@Data
public class AppointmentDTO {
    private Integer id;
    private Doctor doctor;
    private Patient patient;
    private Date date;
}
