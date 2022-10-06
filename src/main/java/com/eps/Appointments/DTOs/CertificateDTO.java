package com.eps.Appointments.DTOs;

import lombok.Data;

@Data
public class CertificateDTO {

    private int id;
    private PatientDTO patient;
    private String rute;
    private String type;

}
