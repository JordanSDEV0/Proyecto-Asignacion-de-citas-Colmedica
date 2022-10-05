package com.eps.Appointments.DTOs;

import lombok.Data;

@Data
public class AppointmentDTO {

    private int id;
    private DoctorDTO doctordDTO;
    private PatientDTO patientDTO;
    private DateDTO dateDTO;
}
