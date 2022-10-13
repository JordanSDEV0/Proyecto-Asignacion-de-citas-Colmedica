package com.eps.Appointments.DTOs;

import java.time.LocalDate;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class PatientDTO {

    private String id;
    private String password;
    private int idTypeId;
    private int headquarterId;
    private int ocupationId;
    private String regimenType;
    private String phone;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private LocalDate birthDate;
    private String genre;

}
