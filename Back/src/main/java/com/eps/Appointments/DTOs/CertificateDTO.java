/**
* Package with which the DTOs of the appointments is accessed
**/
package com.eps.Appointments.DTOs;
/**
* Imports of date
*/
import lombok.Data;
/**
* Imports of lombok
*/
import lombok.AllArgsConstructor;
/**
* Public class for dto certificated
* @Data allows the use of db data and persistence
* @AllArgsConstructor annotation automatically generates a constructor with a parameter for each field in your class
**/
@Data
@AllArgsConstructor
public class CertificateDTO {
    
    /**
    * Private attribute of type int of name id
    **/
    private int id;
    /**
    * Private attribute of type PatientDTO of name patient
    **/
    private PatientDTO patient;
    /**
    * Private attribute of type String of name rute
    **/
    private String rute;
    /**
    * Private attribute of type String of name type
    **/
    private String type;

}
