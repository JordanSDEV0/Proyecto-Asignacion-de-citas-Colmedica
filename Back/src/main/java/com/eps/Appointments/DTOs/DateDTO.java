package com.eps.Appointments.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class DateDTO {

    private int id;
    private int dateTypeId;
	private int headquarterId;
    private String description;	
	private LocalDateTime initialTime;
	private LocalDateTime finalTime;
	private LocalDate date;
	private String status;
	    
}
