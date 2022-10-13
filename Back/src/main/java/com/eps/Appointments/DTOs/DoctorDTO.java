package com.eps.Appointments.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorDTO {

    private String id;
    private String password;
    private int headquarterId;
    private List<SpecializationDTO> specializationList;

}
