package com.eps.Appointments.DTOs;

import java.time.LocalDate;

import com.eps.Appointments.persistance.entities.Headquarter;
import com.eps.Appointments.persistance.entities.IdType;
import com.eps.Appointments.persistance.entities.Ocupation;
import com.eps.Appointments.persistance.entities.User;

import lombok.Data;

@Data
public class PatientDTO {
    private User user;
    private IdType idType;
    private Headquarter headquarter;
    private Ocupation ocupation;
    private String regimenType;
    private String phone;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private LocalDate birthDate;
    private String genre;
}
