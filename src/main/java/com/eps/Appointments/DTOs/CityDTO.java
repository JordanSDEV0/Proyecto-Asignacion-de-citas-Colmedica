package com.eps.Appointments.DTOs;

import lombok.Data;

@Data
public class CityDTO {

    private int id;
	private DepartmentDTO department;
    private String city;

}
