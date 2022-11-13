/**
* Package with which the DTOs of the appointments is accessed
**/
package com.eps.Appointments.DTOs;

/**
* Imports of java
*/
import java.util.List;
/**
* Imports of lombok
*/
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Public class for dto doctor
 * 
 * @Data allows the use of db data and persistence
 * @AllArgsConstructor annotation automatically generates a constructor with a
 *                     parameter for each field in your class
 **/
@Data
@AllArgsConstructor
public class DoctorDTO {
    /**
     * Private attribute of type String of name id
     **/
    private String id;
    /**
     * Private attribute of type String of name password
     **/
    private String password;

    /**
     * Private attribute of type int of name headquarterId
     **/
    private int headquarterId;
    private String name;
    private String lastName;
    private String email;
    private int phone;
    /**
     * Private attribute of type list SpecializationDTO of name specializationList
     **/
    private List<SpecializationDTO> specializationList;

}
