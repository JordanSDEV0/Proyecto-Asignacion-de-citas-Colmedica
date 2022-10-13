package com.eps.Appointments.DTOs;

import lombok.Data;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class CityDTO {

    private int id;
	private DepartmentDTO department;
    private String city;

}
