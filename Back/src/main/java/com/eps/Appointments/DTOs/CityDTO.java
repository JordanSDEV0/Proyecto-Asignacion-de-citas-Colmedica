/**
* Package with which the DTOs of the appointments is accessed
**/
package com.eps.Appointments.DTOs;
/**
* Imports of lombok
*/
import lombok.Data;
import lombok.AllArgsConstructor;
/**
* Public class for dto city
* @Data allows the use of db data and persistence
* @AllArgsConstructor annotation automatically generates a constructor with a parameter for each field in your class
**/
@Data
@AllArgsConstructor
public class CityDTO {
/**
    * Private attribute of type int of name id
    **/
    private int id;
	/**
    * Private attribute of type DepartmentDTO of name department
    **/
	private DepartmentDTO department;
	/**
    * Private attribute of type String of name city
    **/
    private String city;

}
