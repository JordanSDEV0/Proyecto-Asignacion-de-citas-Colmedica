package com.eps.Appointments.DTOs;
import com.eps.Appointments.controllers.AbstractResponse;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Data()
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)public class DateTypeDTO extends AbstractResponse{

	private int id;
	private String description;
    
}
