package com.eps.Appointments.DTOs;

import com.eps.Appointments.persistance.entities.Headquarter;
import com.eps.Appointments.persistance.entities.Specialization;
import com.eps.Appointments.persistance.entities.User;

import lombok.Data;

@Data
public class IdTypeDTO {
	private Integer id;
    private String type;
    
}
