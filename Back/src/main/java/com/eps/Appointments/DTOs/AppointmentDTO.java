/**
* Package with which the DTOs of the appointments is accessed
**/
package com.eps.Appointments.DTOs;
/**
* Imports of lombok
*/
import lombok.Data;
/**
* Public class for dto appointment
* @Data allows the use of db data and persistence
**/
@Data
public class AppointmentDTO {
/**
    * Private attribute of type int of name id
    **/
    private int id;
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
