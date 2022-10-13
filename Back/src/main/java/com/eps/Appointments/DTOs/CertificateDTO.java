package com.eps.Appointments.DTOs;

import lombok.Data;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class CertificateDTO {

    private int id;
    private PatientDTO patient;
    private String rute;
    private String type;

}
