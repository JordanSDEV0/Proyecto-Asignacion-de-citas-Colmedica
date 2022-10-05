package com.eps.Appointments.DTOs;

import lombok.Data;

@Data
public class AppointmentDTO {

    private int id;
    private DoctorDTO doctord;
    private PatientDTO patient;
    private DateDTO date;
}
