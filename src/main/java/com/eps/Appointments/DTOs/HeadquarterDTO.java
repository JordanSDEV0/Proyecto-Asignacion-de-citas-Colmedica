package com.eps.Appointments.DTOs;

import lombok.Data;

@Data
public class HeadquarterDTO {

    private int id;
    private CityDTO cityDTO;
	private String name;
	private String address;

}
