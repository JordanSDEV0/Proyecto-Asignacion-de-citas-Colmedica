package com.eps.Appointments.DTOs;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PatientDTO {

    private String id;
    private String password;
    private IdTypeDTO idType;
    private HeadquarterDTO headquarter;
    private OcupationDTO ocupation;
    private String regimenType;
    private String phone;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private LocalDate birthDate;
    private String genre;

}
