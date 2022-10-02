package com.eps.Appointments.DTOs;

import java.util.List;

import com.eps.Appointments.persistance.entities.Headquarter;
import com.eps.Appointments.persistance.entities.Specialization;
import com.eps.Appointments.persistance.entities.User;

import lombok.Data;

@Data
public class DoctorDTO {
    private User user;
    private Headquarter headquarter;
    private List<Specialization> specialization;


}
