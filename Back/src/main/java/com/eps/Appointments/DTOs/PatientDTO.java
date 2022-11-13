/**
* Package with which the DTOs of the appointments is accessed
**/
package com.eps.Appointments.DTOs;

/**
* Imports of time
*/
import java.time.LocalDate;
/**
* Imports of lombok
*/
import lombok.Data;
import lombok.AllArgsConstructor;

/**
 * Public class for dto patient
 * 
 * @Data allows the use of db data and persistence
 * @AllArgsConstructor annotation automatically generates a constructor with a
 *                     parameter for each field in your class
 **/
@Data
@AllArgsConstructor
public class PatientDTO {
    /**
     * Private attribute of type String of name id
     **/
    private String id;
    /**
     * Private attribute of type String of name password
     **/
    private String password;

    /**
     * Private attribute of type int of name idTypeId
     **/
    private int idTypeId;
    /**
     * Private attribute of type int of name headquarterId
     **/
    private int headquarterId;
    /**
     * Private attribute of type int of name ocupationId
     **/
    private int ocupationId;
    /**
     * Private attribute of type String of name regimenType
     **/
    private String regimenType;
    /**
     * Private attribute of type String of name phone
     **/
    private String phone;
    /**
     * Private attribute of type String of name name
     **/
    private String name;
    /**
     * Private attribute of type String of name lastName
     **/
    private String lastName;
    /**
     * Private attribute of type String of name address
     **/
    private String address;
    /**
     * Private attribute of type String of name email
     **/
    private String email;
    /**
     * Private attribute of type LocalDate of name birthDate
     **/
    private LocalDate birthDate;
    /**
     * Private attribute of type String of name genre
     **/
    private String genre;

}
