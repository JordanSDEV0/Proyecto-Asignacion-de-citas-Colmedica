package com.eps.Appointments.DTOs;

import lombok.Data;

@Data
public class AppointmentDTO {

    private int id;
    private String doctorId;
    private String patientId;
    private int dateId;

}
