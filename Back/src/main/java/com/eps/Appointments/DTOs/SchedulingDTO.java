package com.eps.Appointments.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SchedulingDTO {
  
  private int dateTypeId;
	private int headquarterId;
  private String description;	
	private LocalDateTime initialTime;
	private LocalDateTime finalTime;
	private LocalDate date;
	private String status;
  private String doctorId;
  private String patientId;
  private int dateId;

}
