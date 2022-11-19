/**
* Package with which the DTOs of the appointments is accessed
**/
package com.eps.Appointments.DTOs;

import java.util.Date;

import lombok.AllArgsConstructor;
/**
* Imports of lombok
*/
import lombok.Data;

/**
 * Public class for dto appointment
 *
 * @Data allows the use of db data and persistence
 **/
@Data
@AllArgsConstructor
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
    private Date initialTime;
    /**
     * Private attribute of type LocalDateTime of name finalTime
     **/
    private Date finalTime;
    /**
     * Private attribute of type LocalDate of name date
     **/
    private Date date;
    /**
     * Private attribute of type String of name status
     **/
    private String status;

}
