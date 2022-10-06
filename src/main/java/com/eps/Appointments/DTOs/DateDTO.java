package com.eps.Appointments.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;


import com.eps.Appointments.controllers.AbstractResponse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Data()
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DateDTO extends AbstractResponse{

    private int id;
    private DateTypeDTO dateType;
	private HeadquarterDTO headquarter;
    private String description;	
	private LocalDateTime initialTime;
	private LocalDateTime finalTime;
	private LocalDate date;
	private String status;
	    

}
