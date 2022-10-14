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
* Public class for dto user
* @Data allows the use of db data and persistence
* @AllArgsConstructor annotation automatically generates a constructor with a parameter for each field in your class
**/
@Data
@AllArgsConstructor
public class UserDTO {
	/**
   	 * Private attribute of type String of name id
   	 **/
	private String id;
	/**
  	  * Private attribute of type String of name password
  	  **/
	private String password;

}
