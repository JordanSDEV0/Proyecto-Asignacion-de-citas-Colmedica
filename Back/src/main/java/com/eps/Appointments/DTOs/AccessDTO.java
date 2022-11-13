/**
* Package with which the DTOs of the appointments is accessed
**/
package com.eps.Appointments.DTOs;

/**
* Imports of time
*/
import java.util.Date;

/**
* Imports of lombok
*/
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Public class for dto access
 *
 * @Data allows the use of db data and persistence
 * @AllArgsConstructor annotation automatically generates a constructor with a
 *                     parameter for each field in your class
 **/
@Data
@AllArgsConstructor
public class AccessDTO {
    /**
     * Private attribute of type int of name id
     **/
    private int id;
    /**
     * Private attribute of type UserDTO of name user
     **/
    private UserDTO user;
    /**
     * Private attribute of type LocalDateTime of name accessTime
     **/
    private Date accessTime;

}
