package com.eps.Appointments.DTOs;

import lombok.Data;


import com.eps.Appointments.controllers.AbstractResponse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Data()
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OcupationDTO extends AbstractResponse{

	private int id;
	private String ocupation;


}
