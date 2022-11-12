/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.entities;
/**
* Imports persistence
*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
* Imports of lombok.data
*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * From this class you can access the user
 * @entity The Entity Framework allows developers to work with data in the form of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 * @author:Software Bosque S.A
 *
 */
@Entity(name = "eps_user")
@NoArgsConstructor
@Data
@AllArgsConstructor
/**
 * This class will be user and will have attributes of a private type with its respective Id and password to be able to access
 */
public class User {

    public User(String id2, String password2) {
    }
    @Id
    /** 
    * Private attribute of String type with name id
    **/
    private String id;
    @Column(nullable = false)
    /** 
    * Private attribute of String type with name password
    **/
    private String password;
    private int rol;

    
}
