package com.eps.Appointments.DTOs;

import com.eps.Appointments.persistance.entities.Patient;
import lombok.Data;

@Data
public class CertificateDTO {
    private Integer id;
    private Patient patient;
    private String rute;
    private String type;
}
