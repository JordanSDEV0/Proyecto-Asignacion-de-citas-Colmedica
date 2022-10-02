package com.eps.Appointments.DTOs;

import com.eps.Appointments.persistance.entities.City;
import lombok.Data;

@Data
public class HeadquarterDTO {
    	private Integer id;
    	private City city;
	    private String name;
	    private String address;

}
