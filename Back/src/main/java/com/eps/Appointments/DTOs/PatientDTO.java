package com.eps.Appointments.DTOs;

import java.time.LocalDate;

import lombok.Data;


import com.eps.Appointments.controllers.AbstractResponse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Data()
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PatientDTO extends AbstractResponse{

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
