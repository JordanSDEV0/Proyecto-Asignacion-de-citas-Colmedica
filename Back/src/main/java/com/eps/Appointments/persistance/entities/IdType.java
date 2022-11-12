/**
* Package with which the persistence of the repositories is accessed
**/
package com.eps.Appointments.persistance.entities;

/**
* Imports persistence
*/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
* Imports of lombok.data
*/
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IdType class is created to hold each type of ID
 *
 * @entity The Entity Framework allows developers to work with data in the form
 *         of specific objects and properties
 * @noargsconstructor will generate a constructor with no parameters
 * @Data allows the use of class data
 * @author:Software Bosque S.A
 */
@Entity
@NoArgsConstructor
@Data
public class IdType {
    /**
     * Its attributes are defined, which are id and type, with their respective
     * types, which are private.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * Private attribute of numeric type with name id
     **/
    private Integer id;
    /**
     * Private attribute of String type with name type
     **/
    private String type;

}
