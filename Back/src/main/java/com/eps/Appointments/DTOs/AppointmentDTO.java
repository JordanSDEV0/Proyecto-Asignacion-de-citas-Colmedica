package com.eps.Appointments.DTOs;

import com.eps.Appointments.controllers.AbstractResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentDTO extends AbstractResponse{

    private int id;
    private String doctorId;
    private String patientId;
    private int dateId;

}
