package com.eps.Appointments.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.eps.Appointments.persistance.entities.DateType;
import com.eps.Appointments.persistance.entities.Headquarter;

import lombok.Data;

@Data
public class DateDTO {
    private Integer id;
    private DateType dateType;
	private Headquarter headquarter;
    private String description;	
	private LocalDateTime initialTime;
	 	private LocalDateTime finalTime;
	    private LocalDate date;
	    private String status;
	    

}
