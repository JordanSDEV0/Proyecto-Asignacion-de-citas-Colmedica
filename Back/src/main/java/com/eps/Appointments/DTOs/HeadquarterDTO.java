package com.eps.Appointments.DTOs;

import lombok.Data;


import com.eps.Appointments.controllers.AbstractResponse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Data()
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class HeadquarterDTO extends AbstractResponse{

    private int id;
    private CityDTO city;
	private String name;
	private String address;

}
