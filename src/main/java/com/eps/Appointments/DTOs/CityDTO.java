package com.eps.Appointments.DTOs;

import com.eps.Appointments.persistance.entities.Department;
import lombok.Data;

@Data
public class CityDTO {
    private Integer id;
	private Department department;
    private String city;
}
