package com.eps.Appointments.DTOs;

import lombok.Data;

@Data
public class HeadquarterDTO {

    private int id;
    private CityDTO city;
	private String name;
	private String address;

}
