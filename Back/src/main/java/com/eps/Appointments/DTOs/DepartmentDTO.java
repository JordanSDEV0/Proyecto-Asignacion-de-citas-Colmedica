/**
* Package with which the DTOs of the appointments is accessed
**/
package com.eps.Appointments.DTOs;
/**
* Imports of lombok
*/
import lombok.AllArgsConstructor;
import lombok.Data;
/**
* Public class for dto departament
* @Data allows the use of db data and persistence
* @AllArgsConstructor annotation automatically generates a constructor with a parameter for each field in your class
**/
@Data
@AllArgsConstructor
public class DepartmentDTO {
    /**
    * Private attribute of type int of name id
    **/
	private int id;
	    /**
    * Private attribute of type String of name department
    **/
	private String department;
	    
}
