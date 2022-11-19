/**
* Package com.eps.Appointments
**/
package com.eps.Appointments;

/**
* Imports org.springframework
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Inherits the behavior of an annotation set, in this case from the
 * AppointmentsApplication class
 **/
@SpringBootApplication
public class AppointmentsApplication {
	/**
	 * A method needs an object to which to grant functionalities
	 **/
	public static void main(String[] args) {
		SpringApplication.run(AppointmentsApplication.class, args);
	}

}
