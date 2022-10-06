package com.eps.Appointments.DTOs;

import com.eps.Appointments.controllers.AbstractResponse;

import lombok.Data;

@Data
public class AppointmentDTO extends AbstractResponse{

    private int id;
    private DoctorDTO doctor;
    private PatientDTO patient;
    private DateDTO date;

}
