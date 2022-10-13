package com.eps.Appointments.DTOs;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class HeadquarterDTO {

    private int id;
    private CityDTO city;
	private String name;
	private String address;

}
