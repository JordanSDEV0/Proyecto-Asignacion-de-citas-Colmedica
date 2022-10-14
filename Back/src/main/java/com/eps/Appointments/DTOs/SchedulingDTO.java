/**
* Package with which the DTOs of the appointments is accessed
**/
package com.eps.Appointments.DTOs;
/**
* Imports of time
*/
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
* Imports of lombok
*/
import lombok.AllArgsConstructor;
import lombok.Data;
/**
* Public class for dto scheduling
* @Data allows the use of db data and persistence
* @AllArgsConstructor annotation automatically generates a constructor with a parameter for each field in your class
**/
@Data
@AllArgsConstructor
public class SchedulingDTO {
  /**
    * Private attribute of type int of name dateTypeId
    **/
  private int dateTypeId;
	/**
    * Private attribute of type int of name headquarterId
    **/
	private int headquarterId;
	/**
    * Private attribute of type String of name description
    **/
  private String description;	
	/**
    * Private attribute of type LocalDateTime of name initialTime
    **/
	private LocalDateTime initialTime;
	/**
    * Private attribute of type LocalDateTime of name finalTime
    **/
	private LocalDateTime finalTime;
	/**
    * Private attribute of type LocalDate of name date
    **/
	private LocalDate date;
	/**
    * Private attribute of type String of name status
    **/
	private String status;
	/**
    * Private attribute of type String of name doctorId
    **/
  private String doctorId;
	/**
    * Private attribute of type String of name patientId
    **/
  private String patientId;
	/**
    * Private attribute of type int of name dateId
    **/
  private int dateId;

}
