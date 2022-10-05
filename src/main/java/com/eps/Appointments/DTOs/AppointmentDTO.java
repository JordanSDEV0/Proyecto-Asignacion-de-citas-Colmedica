package com.eps.Appointments.DTOs;

import lombok.Data;

@Data
public class AppointmentDTO {

    private int id;
    private DoctorDTO doctor;
    private PatientDTO patient;
    private DateDTO date;
}
