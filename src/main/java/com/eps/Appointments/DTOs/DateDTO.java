package com.eps.Appointments.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DateDTO {

    private int id;
    private DateTypeDTO dateTypeDTO;
	private HeadquarterDTO headquarterDTO;
    private String description;	
	private LocalDateTime initialTime;
	private LocalDateTime finalTime;
	private LocalDate date;
	private String status;
	    

}
